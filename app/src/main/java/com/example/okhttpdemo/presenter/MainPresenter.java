package com.example.okhttpdemo.presenter;

import com.example.okhttpdemo.bean.RecordsBean;
import com.example.okhttpdemo.iview.IMainView;
import com.example.okhttpdemo.model.iml.GetData;
import com.example.okhttpdemo.model.imodel.IGetData;
import com.okhttp.libary.IProgressCallback;
import com.okhttp.libary.IRequestCallback;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;

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
       /* getData.getTaskList(simId, new IRequestCallback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mainView.setResult("get data fail"+e.getMessage());
                e.printStackTrace();
            }

            @Override
            public boolean before() {
                return false;
            }

            @Override
            public void success(String result) {
                mainView.setResult(result);
            }
        });*/

    }


    public void getRecordList(String simId) {
        String startTime = "2016-05-10 10:00:00";
        String endTime = "2016-08-01 10:00:00";
        getData.getRecords(simId, startTime, endTime, new IRequestCallback<List<RecordsBean>>() {
            @Override
            public void onFailure(Call call, IOException e) {
                mainView.setResult("get data fail");
                e.printStackTrace();
            }

            @Override
            public boolean before() {
                return false;
            }

            @Override
            public void success(List<RecordsBean> result) {
                //  List<RecordsBean> listbean = GsonUtils.fromJson(result,new TypeToken<List<RecordsBean>>(){});

                mainView.setResult(result.size() + "");
            }
        });

    }


    public void down() {
        getData.downTest(new IProgressCallback<String>() {
            @Override
            public void progress(long total, long current) {
                mainView.setResultProgress(total, current);
            }

            @Override
            public boolean before() {
                return false;
            }

            @Override
            public void success(String result) {
                mainView.setResult(result);
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }
        });
    }

    public void upload() {
        getData.uploadTest(new IProgressCallback<String>() {
            @Override
            public void progress(long total, long current) {
                mainView.setResultProgress(total, current);
            }

            @Override
            public boolean before() {
                return false;
            }

            @Override
            public void success(String result) {
                mainView.setResult(result);
            }

            /*  @Override
              public void success(String result) {
                  mainView.setResult(result);
              }
  */
            @Override
            public void onFailure(Call call, IOException e) {

            }
        });
    }
}
