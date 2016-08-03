package com.okhttp.libary;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by guozhk on 16-7-28.
 */
public class GetRequest extends OkHttpRequest<GetRequest> {
    protected GetRequest(String url, Object tag) {
        super(url, tag, null, null);
    }

    public GetRequest(String url) {
        this(url, System.currentTimeMillis());
    }


    @Override
    public void appendUrl() {
        if (stringParams == null || stringParams.isEmpty()) return;
        StringBuilder tempParams = new StringBuilder();
        try {
            int pos = 0;
            for (String key : stringParams.keySet()) {
                if (pos > 0) {
                    tempParams.append("&");
                }
                //对参数进行URLEncoder
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(stringParams.get(key).toString(), "utf-8")));
                pos++;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //补全请求地址
        String requestUrl = String.format("%s?%s", url, tempParams.toString());
        url = requestUrl;
    }

    @Override
    protected RequestBody buildRequestBody() {
        return null;
    }

    public RequestCall build() {
        buidParams();
        return new RequestCall(this);
    }
    @Override
    public Request getRequest() {
        return builder.get().build();
    }
}
