package com.example.okhttpdemo.okhttutils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by guozhk on 16-7-28.
 */
public class OkHttpManager {
    public static final long DEFAULT_MILLISECONDS = 10_000L;
    private static volatile OkHttpManager mOkHttpManager;
    private final OkHttpClient mOkHttpClient;
    private final Handler okHttpHandler;


    private OkHttpManager(Context context) {
        //初始化OkHttpClient
        mOkHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(10, TimeUnit.SECONDS)//设置写入超时时间
                .build();
        //初始化Handler
        okHttpHandler = new Handler(context.getMainLooper());
    }

    public static OkHttpManager instance(Context context) {
        OkHttpManager inst = mOkHttpManager;
        if (inst == null) {
            synchronized (OkHttpManager.class) {
                inst = mOkHttpManager;
                if (inst == null) {
                    inst = new OkHttpManager(context.getApplicationContext());
                    mOkHttpManager = inst;
                }
            }
        }
        return inst;
    }

    public static OkHttpManager getInstance() {
        if (mOkHttpManager == null) {
            Exceptions.illegalArgument("OkHttpManager is null");
        }
        return mOkHttpManager;
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

    public GetRequest get(String url) {
        Log.e("okManager","getRequest");
        return new GetRequest(url);
    }
}
