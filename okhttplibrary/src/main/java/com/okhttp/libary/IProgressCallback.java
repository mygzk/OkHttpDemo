package com.okhttp.libary;

/**
 * Created by guozhk on 16-8-4.
 */
public interface IProgressCallback<T> extends IRequestCallback <T>{
    void progress(long total, long current);
}
