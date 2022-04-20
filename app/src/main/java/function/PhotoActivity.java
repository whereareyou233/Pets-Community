package function;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pats_community.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PhotoActivity extends AppCompatActivity {

    TextureView mPreViewView;
    HandlerThread cameraThread;
    Handler mCameraHandler;

    CameraManager cameraManager;
    android.util.Size mPreViewSize;
    android.util.Size mCaptureSize;   //最佳的拍照尺寸

    String mCameraid;
    CameraDevice mcameraDevice;
    CaptureRequest.Builder mCaptureRequestBuilder;
    CaptureRequest mCaptureRequest;
    CameraCaptureSession mcameraCaptureSession;

    ImageReader mimageReader;

    //SparseArray类似于一个map数据结构，以键对值存储
    private static final SparseArray ORIENTATION = new SparseArray();

    static {
        ORIENTATION.append(Surface.ROTATION_0, 90);
        ORIENTATION.append(Surface.ROTATION_90, 0);
        ORIENTATION.append(Surface.ROTATION_180, 270);
        ORIENTATION.append(Surface.ROTATION_270, 180);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        Toolbar toolbar = findViewById(R.id.Toorbar_photo);
        setSupportActionBar(toolbar);

        mPreViewView = findViewById(R.id.textureview);
    }

    //实现具体功能
    @Override
    protected void onResume() {
        super.onResume();

        startCameraThread();
        if (!mPreViewView.isAvailable()) {

            mPreViewView.setSurfaceTextureListener(textureListener);
        } else {
            startPreView();
        }
    }

    TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
            //当SurfaceTexture可用时，设置相机的参数，打开摄像头
            setupCamera(i, i1);
            openCamera();
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {
            //当SurefaceTexture状态改变时调用此方法
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }
        //当SurefaceTexture销毁时调用此方法
        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            //当SurefaceTexture状态更新时调用此方法
        }
    };

    //设置摄像头的参数,setupCamera这个方法主要是根据TextureView来设定相对于的尺寸大小，Camera2中使用CameraManager来管理摄像头
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupCamera(int width, int height) {

        // 获取摄像头的管理者CameraManager
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        //拿到摄像头的id
        try {
            // 遍历所有摄像头
            for (String cameraID : cameraManager.getCameraIdList()) {
                CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraID);
                // 默认打开后置摄像头 - 忽略前置摄像头
                Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                if (facing != null && facing == CameraCharacteristics.LENS_FACING_FRONT) {
                    continue;
                }
                // 获取StreamConfigurationMap，它是管理摄像头支持的所有输出格式和尺寸
                StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

                //找到摄像头能够输出的最符合能够显示界面分辨率的最小值
                if (map != null) {
//                   mPreViewSize=getOptimalSize(map.getOutputSizes(SurfaceTexture.class),width,height);
                    mCaptureSize = Collections.max(Arrays.asList(map.getOutputSizes(ImageFormat.JPEG)), new Comparator<Size>() {
                        @Override
                        public int compare(android.util.Size size, android.util.Size t1) {
                            return Long.signum(size.getWidth() * size.getHeight() - t1.getWidth() * t1.getHeight());
                        }
                    });
                }
                //建立图片缓冲区
                setupImageReader();

                mCameraid = cameraID;
                break;
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    //打开摄像头和权限申请
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void openCamera() {

        String[] permissions = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        int i = 0;
        for (String permission : permissions) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                this.requestPermissions(permissions, i++);
            }
        }

        try {
            cameraManager.openCamera(mCameraid, mStateCallBack, mCameraHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    //CameraDevice.StateCallback 用于接收有关摄像机设备状态的更新的回调对象
    CameraDevice.StateCallback mStateCallBack = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            mcameraDevice = cameraDevice;

            startPreView();
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            mcameraDevice.close();
            mcameraDevice = null;
        }

        @Override
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            mcameraDevice.close();
            mcameraDevice = null;
        }
    };

    //开始预览
    private void startPreView() {
        //建立图形缓冲区
        SurfaceTexture surfaceTexture = mPreViewView.getSurfaceTexture();
        surfaceTexture.setDefaultBufferSize(mPreViewView.getWidth(), mPreViewView.getHeight());

        //得到界面的显示对象
        Surface previewSurface = new Surface(surfaceTexture);
        try {
            //. 先拿到一个 CaptureRequest.Builder 对象
            mCaptureRequestBuilder = mcameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            mCaptureRequestBuilder.addTarget(previewSurface);

            //建立通道
            mcameraDevice.createCaptureSession(Arrays.asList(previewSurface, mimageReader.getSurface()), new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    try {
                        mCaptureRequest = mCaptureRequestBuilder.build();
                        mcameraCaptureSession = cameraCaptureSession;
                        mcameraCaptureSession.setRepeatingRequest(mCaptureRequest, null, mCameraHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {

                }
            }, mCameraHandler);

        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }

    //打开摄像头的线程
    private void startCameraThread() {
        cameraThread = new HandlerThread("CameraThread");
        cameraThread.start();
        mCameraHandler = new Handler(cameraThread.getLooper());
    }

    //开始拍照，静态点击事件
    public void capture(View view) {

        //获取摄像头的请求
        CaptureRequest.Builder mCameraBuilder = null;

        try {
            mCameraBuilder = mcameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        mCameraBuilder.addTarget(mimageReader.getSurface());

        //获取摄像头方向
        int rotation = getWindowManager().getDefaultDisplay().getRotation();

        //设置拍照方向
        mCameraBuilder.set(CaptureRequest.JPEG_ORIENTATION, (Integer) ORIENTATION.get(rotation));
        CameraCaptureSession.CaptureCallback mCaptureCallBack = new CameraCaptureSession.CaptureCallback() {
            @Override
            public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
                super.onCaptureCompleted(session, request, result);
                Toast.makeText(getApplicationContext(), "拍照结束", Toast.LENGTH_LONG).show();
                unLockFocus();
            }
        };

        try {
            mcameraCaptureSession.stopRepeating();
            mcameraCaptureSession.capture(mCameraBuilder.build(), mCaptureCallBack, mCameraHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        Intent intent=new Intent(PhotoActivity.this,AnimalActivity.class);

        startActivity(intent);

        //获取图像的缓冲区
        //获取文件的存储权限及操作
    }
//解锁聚焦
    private void unLockFocus() {
        try {
            mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_CANCEL);
            mcameraCaptureSession.setRepeatingRequest(mCaptureRequestBuilder.build(), null, mCameraHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    //建立图片缓冲区
    private void setupImageReader() {

        mimageReader = ImageReader.newInstance(mCaptureSize.getWidth(), mCaptureSize.getHeight(), ImageFormat.JPEG, 2);
        mimageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
            @Override
            public void onImageAvailable(ImageReader imageReader) {
                mCameraHandler.post(new ImageSaver(imageReader.acquireLatestImage()));
            }
        }, mCameraHandler);
    }

    //获取照片
    private class ImageSaver implements Runnable {

        Image mimage;

        public ImageSaver(Image image) {
            mimage = image;
        }

        @Override
        public void run() {

            ByteBuffer buffer = mimage.getPlanes()[0].getBuffer();
            byte[] data = new byte[buffer.remaining()];
            buffer.get(data);

            String path = Environment.getExternalStorageDirectory() + "/DCIM/CameraV2/";
            File mImageFile = new File(path);
            if (!mImageFile.exists()) {
                mImageFile.mkdir();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filename = path + "IMG_" + timeStamp + ".jpg";

            try {

                FileOutputStream fos = new FileOutputStream(filename);
                fos.write(data, 0, data.length);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

