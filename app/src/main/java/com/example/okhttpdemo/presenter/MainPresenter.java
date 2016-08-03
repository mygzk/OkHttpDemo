package com.example.okhttpdemo.presenter;

import android.os.Looper;

import com.example.okhttpdemo.iview.IMainView;
import com.example.okhttpdemo.model.iml.GetData;
import com.example.okhttpdemo.model.imodel.IGetData;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by guozhk on 16-8-3.
 */
public class MainPresenter {

    private IMainView mainView;
    private IGetData getData;


    public MainPresenter(IMainView mainnView) {
        this.mainView = mainnView;

        getData = new GetData();
    }

    public void getMyTaskList(String simId) {
        getData.getTaskList(simId, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mainView.setResult("get data fail");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mainView.setResult(response.body().string());
            }
        });

    }


    public void getRecordList(String simId) {
        String startTime = "2016-05-10 10:00:00";
        String endTime = "2016-08-01 10:00:00";
        getData.getRecords(simId, startTime, endTime, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mainView.setResult("get data fail");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("mian :"+(Thread.currentThread() == Looper.getMainLooper().getThread()));
                mainView.setResult(response.body().string());
            }
        });

    }


}
