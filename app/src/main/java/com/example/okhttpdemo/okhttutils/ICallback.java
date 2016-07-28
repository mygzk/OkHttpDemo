package com.example.okhttpdemo.okhttutils;

import okhttp3.Callback;

/**
 * Created by guozhk on 16-7-28.
 */
public interface ICallback extends Callback {

    boolean before();
    void progress(long total,long current);
}
