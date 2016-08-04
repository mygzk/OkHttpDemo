package com.example.okhttpdemo.iview;

/**
 * Created by guozhk on 16-8-3.
 */
public interface IMainView {

    void setResult(String result);
    void setResultProgress(long total, long current);
}
