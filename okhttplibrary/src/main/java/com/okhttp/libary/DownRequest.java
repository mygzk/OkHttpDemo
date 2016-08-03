package com.okhttp.libary;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by guozhk on 16-7-28.
 */
public class DownRequest {
    protected final String TAG = this.getClass().getSimpleName();
    protected Request.Builder builder = new Request.Builder();
    protected Map<String, String> headers;

    private String saveFilePath;
    private String fileName;
    private String url;
    private Object tag;


    public DownRequest(String url, String saveFilePath, String fileName) {
        this.url = url;
        this.saveFilePath = saveFilePath;
        this.fileName = fileName;
        this.tag = System.currentTimeMillis();
    }

    public DownRequest buidRequest() {

        builder.url(url).tag(tag);
        appendHeaders();
        return this;
    }

    public DownRequest addTag(String tag) {
        this.tag = tag;
        return this;
    }

    public DownRequest addHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }


    protected void appendHeaders() {
        Headers.Builder headerBuilder = new Headers.Builder();
        if (headers == null || headers.isEmpty()) return;

        for (String key : headers.keySet()) {
            headerBuilder.add(key, headers.get(key));
        }
        builder.headers(headerBuilder.build());
    }

    public void enqueue(ICallback cb) {
        final Callback callback = Platform.getCallback(cb);

        final String fileName1 = fileName;
        final File file = new File(saveFilePath, fileName1);
        if (file.exists()) {
            // successCallBack((T) file, callBack);
            file.delete();
            return;
        }

        OkHttpClient clone = OkHttpManager.getInstance().getOkHttpClient().newBuilder()
                .readTimeout(60 * 1000L, TimeUnit.MILLISECONDS)
                .writeTimeout(60 * 1000L, TimeUnit.MILLISECONDS)
                .connectTimeout(60 * 1000L, TimeUnit.MILLISECONDS)
                .build();

        Call call = clone.newCall(builder.get().build());
        if (callback != null) {
            if (callback instanceof ICallback) {
                if (!((ICallback) callback).before()) {
                    callback.onFailure(call, new IOException("请检查网络 或其他配置"));
                    return;
                }
            }

        }
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    long total = response.body().contentLength();
                    long current = 0;
                    is = response.body().byteStream();
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        current += len;
                        fos.write(buf, 0, len);
                        if (callback != null && callback instanceof ICallback) {
                            ((ICallback) callback).progress(total, current);
                        }
                    }
                    fos.flush();
                    //  successCallBack((T) file, callBack);
                } catch (IOException e) {
                    Log.e(TAG, e.toString());
                    callback.onFailure(call, e);
                    // failedCallBack("下载失败", callBack);
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                        if (fos != null) {
                            fos.close();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, e.toString());
                        callback.onFailure(call, e);
                    }
                }

                callback.onResponse(call, response);
            }
        });
    }

}
