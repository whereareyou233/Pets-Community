package com.example.pats_community.nectwork;

import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 网络请求回调
 * 也是对网络请求的封装，此类是为了获取鉴权token
 *
 * @param <T>
 */
public abstract class NetCallBack<T> implements Callback<T> {//这里实现了retrofit2.Callback

    //访问成功回调
    @Override
    public void onResponse(Call<T> call, Response<T> response) {//数据返回
        if (response != null && response.body() != null && response.isSuccessful()) {
            onSuccess(call, response);
        } else {
            onFailed(response.raw().toString());
        }
    }

    //访问失败回调
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d("data str", t.toString());
        onFailed(t.toString());
    }

    //数据返回
    public abstract void onSuccess(Call<T> call, Response<T> response);

    //失败异常
    public abstract void onFailed(String errorStr);


}

