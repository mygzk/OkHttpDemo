package com.example.okhttpdemo;

import android.app.Application;

import com.okhttp.libary.OkHttpManager;

/**
 * Created by guozhk on 16-8-3.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpManager.instance(getApplicationContext());

    }
}
