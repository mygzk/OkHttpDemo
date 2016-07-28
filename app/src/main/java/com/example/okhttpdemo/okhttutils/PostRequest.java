package com.example.okhttpdemo.okhttutils;

import android.text.TextUtils;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by guozhk on 16-7-28.
 */
public class PostRequest extends OkHttpRequest<PostRequest> {
    protected PostRequest(String url, Object tag, Map<String, Object> params, Map<String, String> headers) {
        super(url, tag, params, headers);
    }

    public PostRequest(String url, Map<String, Object> params) {
        this(url, System.currentTimeMillis(), params, null);
    }

    public PostRequest(String url) {
        this(url, null);
    }


    @Override
    protected void appendUrl() {

    }



    @Override
    protected RequestBody buildRequestBody() {
        RequestBody requestBody = null;
        if (fileParams != null && !fileParams.isEmpty()) {
            MultipartBody.Builder builder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM);
            if (stringParams != null) {
                for (String key : stringParams.keySet()) {
                    Object object = stringParams.get(key);
                    builder.addFormDataPart(key, object.toString());
                }
            }
            long total = 0;
            for (String key : fileParams.keySet()) {
                Object object = fileParams.get(key);
                File file = (File) object;
                total = total + file.length();
                String type = FileMimeType.getMimeType(file);
                if (TextUtils.isEmpty(type)) {
                    type = OkHttpContanse.CONTENT_DEFAULT_TYPE;
                }
                // builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse(type), file));
                builder.addFormDataPart(key, file.getName(), new ProgressRequestBody(MediaType.parse(type), file, total,mCallback));
            }
            requestBody = builder.build();

        } else {
            FormBody.Builder builder = new FormBody.Builder();
            if (stringParams != null) {
                for (String key : stringParams.keySet()) {
                    builder.add(key, stringParams.get(key));
                }
            }
            requestBody = builder.build();
        }

        return requestBody;
    }


    @Override
    public RequestCall build() {
        buidParams();
        return new RequestCall(this);
    }
    @Override
    public Request getRequest() {
        return builder.post(buildRequestBody()).build();
    }
}
