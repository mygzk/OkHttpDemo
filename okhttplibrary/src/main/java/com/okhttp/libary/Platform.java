package com.okhttp.libary;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by guozhk on 16-7-28.
 */
public class Platform {

    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static Callback getCallback(final IRequestCallback callback) {

        return new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure(call, e);
                    }
                });
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String resultType = response.body().contentType().toString();
                    String result = "";
                    if (resultType.contains("text/html")) {
                        result = response.body().string();
                    } else {
                        result = "请求成功";
                    }

                    final String finalResult = result;
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.success(finalResult);
                        }
                    });
                } else {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFailure(call, new IOException("unKonw fail..."));
                        }
                    });
                }

            }
        };

    }
}
