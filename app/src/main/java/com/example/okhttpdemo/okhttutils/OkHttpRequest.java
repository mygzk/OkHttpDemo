package com.example.okhttpdemo.okhttutils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by guozhk on 16-7-28.
 */
public abstract class OkHttpRequest<T extends OkHttpRequest> {
    protected  final String TAG = this.getClass().getSimpleName();
    protected ICallback mCallback;
    protected String url;
    protected Object tag;
    private Map<String, Object> params;
    protected Map<String, String> headers;

    protected Map<String, String> stringParams;
    protected Map<String, File> fileParams;

    protected Request.Builder builder = new Request.Builder();

    protected OkHttpRequest(String url, Object tag,
                            Map<String, Object> params, Map<String, String> headers) {
        this.url = url;
        this.tag = tag;
        this.params = params;
        this.headers = headers;

        if (url == null) {
            Exceptions.illegalArgument("url can not be null.");
        }
    }


    public T params(Map<String, Object> params) {
        this.params = params;
        initParams(params);
        return (T) this;
    }

    public T headers(Map<String, String> headers) {
        this.headers = headers;
        return (T) this;
    }

    public T tag(Object tag) {
        this.tag = tag;
        return (T) this;
    }

    private void initParams(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return;
        }
        for (String key : params.keySet()) {
            Object object = params.get(key);
            if (object instanceof File) {
                if (fileParams == null) fileParams = new HashMap<>();
                fileParams.put(key, (File) object);
            } else {
                if (stringParams == null) stringParams = new HashMap<>();
                stringParams.put(key, object.toString());
            }
        }
    }


    /**
     * 初始化一些基本参数 url , tag , headers
     */
    protected T buidParams() {
        appendUrl();
        builder.url(url).tag(tag);
        appendHeaders();
        return (T) this;
    }

    protected abstract void appendUrl();


    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

    public abstract RequestCall build();

    protected abstract RequestBody buildRequestBody();

    public void setCallback(ICallback mCallback) {
        this.mCallback = mCallback;
    }

    protected abstract Request getRequest();
}
