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

    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public static Callback getCallback(final Callback callback) {
        if (callback instanceof ICallback) {
            return new ICallback() {
                @Override
                public boolean before() {
                    return ((ICallback) callback).before();
                }

                @Override
                public void progress(final long total, final long current) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((ICallback) callback).progress(total, current);
                        }
                    });

                }

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
                public void onResponse(final Call call, final Response response) throws IOException {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callback.onResponse(call, response);
                            } catch (IOException e) {
                                callback.onFailure(call, e);
                                e.printStackTrace();
                            }
                        }
                    });

                }
            };
        } else {
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
                public void onResponse(final Call call, final Response response) throws IOException {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callback.onResponse(call, response);
                            } catch (IOException e) {
                                callback.onFailure(call, e);
                                e.printStackTrace();
                            }
                        }
                    });
                }
            };
        }

    }

}
