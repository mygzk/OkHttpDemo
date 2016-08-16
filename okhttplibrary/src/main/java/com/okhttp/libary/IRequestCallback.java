package com.okhttp.libary;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by guozhk on 16-8-4.
 */
public interface IRequestCallback {

    boolean before();

    void success(String result);

    void onFailure(Call call, IOException e);

}
