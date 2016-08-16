package com.example.okhttpdemo.bean;

/**
 * Created by guozhk on 16-8-15.
 */
public class ResultBean<T> {
    private int errCode;
    private String errMsg;
    private T data;
}
