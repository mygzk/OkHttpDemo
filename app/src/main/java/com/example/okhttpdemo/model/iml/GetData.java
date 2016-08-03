package com.example.okhttpdemo.model.iml;

import com.example.okhttpdemo.Constant;
import com.example.okhttpdemo.model.imodel.IGetData;
import com.okhttp.libary.OkHttpManager;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;

/**
 * Created by guozhk on 16-8-3.
 */
public class GetData implements IGetData {
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private Map<String, Object> params = new HashMap<>();

    @Override
    public void getTaskList(String simId, Callback callback) {
        clearParams();
        params.put("sim", simId);
        okHttpManager.post(Constant.TASK_LIST).params(params).build().enqueue(callback);
    }


    @Override
    public void getRecords(String simId, String startTime, String endTime, Callback callback) {
        clearParams();
        params.put("simCode", simId);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        okHttpManager.post(Constant.RECORDS).params(params).build().enqueue(callback);
    }

    @Override
    public void getOrgIdBysim(String sim, Callback callback) {
        clearParams();
        params.put("sim", sim);
        okHttpManager.post(Constant.getOrgIdBysim).params(params).build().enqueue(callback);
    }

    @Override
    public void getChildOrg(String orgId, Callback callback) {
        clearParams();
        params.put("orgId", orgId);
        okHttpManager.post(Constant.getChildOrg).params(params).build().enqueue(callback);
    }

    @Override
    public void getAreaList(String simCode, Callback callback) {
        clearParams();
        params.put("simCode", simCode);
        okHttpManager.post(Constant.getAreaList).params(params).build().enqueue(callback);
    }

    @Override
    public void startWork(String simCode, String lng, String lat, String simId, String remark, Callback callback) {
        clearParams();
        params.put("simCode", simCode);
        params.put("lng", lng);
        params.put("lat", lat);
        params.put("simId", simId);
        params.put("remark", remark);
        okHttpManager.post(Constant.startWork).params(params).build().enqueue(callback);
    }

    @Override
    public void finishWork(String simCode, String lng, String lat, String simId, String remark, Callback callback) {
        clearParams();
        params.put("simCode", simCode);
        params.put("lng", lng);
        params.put("lat", lat);
        params.put("simId", simId);
        params.put("remark", remark);
        okHttpManager.post(Constant.finishWork).params(params).build().enqueue(callback);
    }

    @Override
    public void getAreaById(String areaId, Callback callback) {
        clearParams();
        params.put("areaId", areaId);
        okHttpManager.post(Constant.getAreaById).params(params).build().enqueue(callback);
    }

    @Override
    public void getUserInfo(String simCode, Callback callback) {
        clearParams();
        params.put("simCode", simCode);
        okHttpManager.post(Constant.getUserInfo).params(params).build().enqueue(callback);
    }

    @Override
    public void getAlarmType(Callback callback) {
        okHttpManager.post(Constant.getAlarmType).build().enqueue(callback);
    }

    @Override
    public void changePWD(String simId, String oldPWD, String newPWD, Callback callback) {
        clearParams();
        params.put("simId", simId);
        params.put("oldPWD", oldPWD);
        params.put("newPWD", newPWD);
        okHttpManager.post(Constant.changePWD).params(params).build().enqueue(callback);
    }

    @Override
    public void getAllUserInfo(String simCode, String type, Callback callback) {
        clearParams();
        params.put("simCode", simCode);
        params.put("type", type);
        okHttpManager.post(Constant.getAllUserInfo).params(params).build().enqueue(callback);
    }

    private void clearParams() {
        params.clear();
    }
}
