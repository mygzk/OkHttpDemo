package com.example.okhttpdemo.okhttutils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Request;

/**
 * Created by guozhk on 16-7-28.
 */
public class GetRequest {

    protected String url;
    protected Object tag;
    protected Map<String, String> params;
    protected Map<String, String> headers;


    protected Request.Builder builder = new Request.Builder();

    protected GetRequest(String url, Object tag) {
        this.url = url;
        this.tag = tag;
        if (url == null) {
            Exceptions.illegalArgument("url can not be null.");

        }
    }

    protected GetRequest(String url) {
        this(url, System.currentTimeMillis());
    }

    public GetRequest params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public GetRequest headers(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public GetRequest tag(Object tag) {
        this.tag = tag;
        return this;
    }


    /**
     * 初始化一些基本参数 url , tag , headers
     */
    public GetRequest buidRequest() {
        appendUrl();
        builder.url(url).tag(tag);
        appendHeaders();
        return this;
    }

    private void appendUrl() {
        if (params == null || params.isEmpty()) return;
        StringBuilder tempParams = new StringBuilder();
        try {
            int pos = 0;
            for (String key : params.keySet()) {
                if (pos > 0) {
                    tempParams.append("&");
                }
                //对参数进行URLEncoder
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(params.get(key), "utf-8")));
                pos++;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //补全请求地址
        String requestUrl = String.format("%s?%s", url, tempParams.toString());
        url = requestUrl;
    }


    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

    public RequestGetCall build() {
        return new RequestGetCall(builder.get().build());
    }


}
