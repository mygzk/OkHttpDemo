package com.okhttp.libary;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by guozhk on 16-8-4.
 */
public interface IRequestCallback<T> {

    boolean before();

    void success(T result);

    void onFailure(Call call, IOException e);

}
