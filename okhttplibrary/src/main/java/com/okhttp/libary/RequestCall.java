package com.okhttp.libary;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by guozhk on 16-7-28.
 */
public class RequestCall {
    private long readTimeOut;
    private long writeTimeOut;
    private long connTimeOut;

    private Request request;
    private Call call;
    private OkHttpClient clone;

    private OkHttpRequest okHttpRequest;


    public RequestCall(OkHttpRequest okHttpRequest) {
        this.okHttpRequest = okHttpRequest;
    }

    public RequestCall readTimeOut(long readTimeOut) {
        this.readTimeOut = readTimeOut;
        return this;
    }

    public RequestCall writeTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
        return this;
    }

    public RequestCall connTimeOut(long connTimeOut) {
        this.connTimeOut = connTimeOut;
        return this;
    }


    public RequestCall addRequet(Request rq) {
        request = rq;
        return this;
    }

    private Call buildCall() {
        if (readTimeOut > 0 || writeTimeOut > 0 || connTimeOut > 0) {
            readTimeOut = readTimeOut > 0 ? readTimeOut : OkHttpManager.DEFAULT_MILLISECONDS;
            writeTimeOut = writeTimeOut > 0 ? writeTimeOut : OkHttpManager.DEFAULT_MILLISECONDS;
            connTimeOut = connTimeOut > 0 ? connTimeOut : OkHttpManager.DEFAULT_MILLISECONDS;

            clone = OkHttpManager.getInstance().getOkHttpClient().newBuilder()
                    .readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                    .writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
                    .connectTimeout(connTimeOut, TimeUnit.MILLISECONDS)
                    .build();


            call = clone.newCall(request);
        } else {
            call = OkHttpManager.getInstance().getOkHttpClient().newCall(request);
        }
        return call;
    }


    /**
     * 同步
     *
     * @return Response
     * @throws IOException
     */
    public Response execute() throws IOException {
        buildCall();
        return call.execute();
    }

    /**
     * 异步
     *
     * @param cb 回调函数
     */
    public <T> void enqueue(IRequestCallback<T> cb) {
        if (cb == null) {
            Log.e("callrequest", "回到函数为空");
            return;
        }
        if (cb.before()) {
            cb.onFailure(call, new IOException("请检查网络 或其他配置"));
            return;
        }


        if (okHttpRequest != null) {
            if (cb instanceof IProgressCallback) {
                okHttpRequest.setCallback((IProgressCallback) cb);
            }
            addRequet(okHttpRequest.getRequest());
        }

        final Callback callback = new Platform<T>().getCallback(cb);

        buildCall();

        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                callback.onFailure(call, e);

            }

            @Override
            public void onResponse(final Call call, final Response response) {
                try {
                    callback.onResponse(call, response);
                } catch (IOException e) {
                    callback.onFailure(call, e);
                    e.printStackTrace();
                }


            }
        });
    }


    public void cancel() {
        if (call != null) {
            call.cancel();
        }
    }


}
