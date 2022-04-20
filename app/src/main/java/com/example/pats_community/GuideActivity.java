package com.example.pats_community;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {


    private ViewPager mVp_Guide;
    private View mGuideRedPoint;
    private LinearLayout mLlGuidePoints;

    private int disPoints;
    private int currentItem;
    private Guide_Adapter adapter;
    private List<ImageView> guids;

    //向导界面的图片
    private int[] mPics = new int[]{R.mipmap.guide3, R.mipmap.guide2, R.mipmap.guide1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences setting = getSharedPreferences("com.example.welcome",
                0);
        Boolean user_first = setting.getBoolean("FIRST", true);

        if (user_first) {// 第一次则跳转到欢迎页面
            setting.edit().putBoolean("FIRST", false).commit();
        } else {// 如果是第二次启动则直接跳转到主页面
            Intent mIntent = new Intent(GuideActivity.this,
                    MainActivity.class);
            startActivity(mIntent);
            finish();
            finish();
        }

        setContentView(R.layout.activity_guide);

        UIUtils.init(getApplicationContext());
        Button button = findViewById(R.id.but);
        button.setVisibility(View.GONE);
        TextView t1 = findViewById(R.id.pho1);

        TextView t2 = findViewById(R.id.pho2);
        t2.setVisibility(View.GONE);
        SpannableString ss = new SpannableString("宠物社区\n在这里你可以分享和宠物的日常");
        ss.setSpan(new AbsoluteSizeSpan(40, true), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        t1.setText(ss);
        initView();
        initData();
        initEvent();

    }


    private void initView() {
        mVp_Guide = (ViewPager) findViewById(R.id.vp_guide);
        mGuideRedPoint = findViewById(R.id.v_guide_redpoint);

        mLlGuidePoints = (LinearLayout) findViewById(R.id.ll_guide_points);
    }

    private void initData() {
        // viewpaper adapter适配器
        guids = new ArrayList<ImageView>();

        //创建viewpager的适配器
        for (int i = 0; i < mPics.length; i++) {
            ImageView iv_temp = new ImageView(getApplicationContext());
            iv_temp.setBackgroundResource(mPics[i]);

            //添加界面的数据
            guids.add(iv_temp);

            //灰色的点在LinearLayout中绘制：
            //获取点
            View v_point = new View(getApplicationContext());
            v_point.setBackgroundResource(R.drawable.point_smiple);//灰点背景色
            //设置灰色点的显示大小
            int dip = 10;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(UIUtils.dp2Px(dip), UIUtils.dp2Px(dip));
            //设置点与点的距离,第一个点除外
            if (i != 0)
                params.leftMargin = 47;
            v_point.setLayoutParams(params);

            mLlGuidePoints.addView(v_point);
        }

        // 创建viewpager的适配器
        adapter = new Guide_Adapter(getApplicationContext(), guids);
        // 设置适配器
        mVp_Guide.setAdapter(adapter);
    }

    private void initEvent() {
        //监听界面绘制完成
        mGuideRedPoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //取消注册界面而产生的回调接口
                mGuideRedPoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                //计算点于点之间的距离
                disPoints = (mLlGuidePoints.getChildAt(1).getLeft() - mLlGuidePoints.getChildAt(0).getLeft());
            }
        });

        //滑动事件监听滑动距离，点更随滑动。
        mVp_Guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                TextView t1 = findViewById(R.id.pho1);


                SpannableString ss1 = new SpannableString("膳食推荐\n给予宠物最好的营养搭配");

                ss1.setSpan(new AbsoluteSizeSpan(40, true), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                t1.setVisibility(View.VISIBLE);
                TextView t2 = findViewById(R.id.pho2);
                Button button = findViewById(R.id.but);

                button.setVisibility(View.GONE);

                t2.setText(ss1);
                t2.setVisibility(View.GONE);
                //当前viewpager显示的页码
                //如果viewpager滑动到第三页码（最后一页），显示进入的button
                if (position == guids.size() - 1) {

                    t1.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);//设置按钮的显示
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            startActivity(intent);
                            //这部分代码是切换Activity时的动画，看起来就不会很生硬
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        }
                    });
                } else if (position == guids.size() - 2) {
                    t1.setVisibility(View.GONE);
                    t2.setVisibility(View.VISIBLE);
                }
                currentItem = position;
            }

            /**
             *页面滑动调用，拿到滑动距离设置视图的滑动状态
             * @param position 当前页面位置
             * @param positionOffset 移动的比例值
             * @param positionOffsetPixels 便宜的像素
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //计算红点的左边距
                float leftMargin = disPoints * (position + positionOffset);
                //设置红点的左边距
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mGuideRedPoint.getLayoutParams();
                //对folat类型进行四舍五入，
                layoutParams.leftMargin = Math.round(leftMargin);
                //设置位置
                mGuideRedPoint.setLayoutParams(layoutParams);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mVp_Guide.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float endX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = event.getX();
                        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                        //获取屏幕的宽度
                        Point size = new Point();
                        windowManager.getDefaultDisplay().getSize(size);
                        int width = size.x;
                        //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                        if (currentItem == (guids.size() - 1) && startX - endX >= (width / 4)) {
                            //进入主页
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            startActivity(intent);
                            //这部分代码是切换Activity时的动画，看起来就不会很生硬
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        }
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}