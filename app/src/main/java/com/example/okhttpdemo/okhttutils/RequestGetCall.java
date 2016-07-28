package com.example.okhttpdemo.okhttutils;

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
public class RequestGetCall {
    private long readTimeOut;
    private long writeTimeOut;
    private long connTimeOut;

    private Request request;
    private Call call;
    private OkHttpClient clone;

    public RequestGetCall(Request request) {
        this.request = request;
    }

    public RequestGetCall readTimeOut(long readTimeOut) {
        this.readTimeOut = readTimeOut;
        return this;
    }

    public RequestGetCall writeTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
        return this;
    }

    public RequestGetCall setConnTimeOut(long connTimeOut) {
        this.connTimeOut = connTimeOut;
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


    public Response execute() throws IOException {
        buildCall();
        return call.execute();
    }

    public void enqueue(Callback callback){
        buildCall();
        call.enqueue(callback);
    }

    public void cancel() {
        if (call != null) {
            call.cancel();
        }
    }


}
