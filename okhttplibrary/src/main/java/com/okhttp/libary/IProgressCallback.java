package com.okhttp.libary;

/**
 * Created by guozhk on 16-8-4.
 */
public interface IProgressCallback extends IRequestCallback{
    void progress(long total, long current);
}
