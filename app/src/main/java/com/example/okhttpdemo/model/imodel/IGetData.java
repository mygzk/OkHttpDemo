package com.example.okhttpdemo.model.imodel;

import okhttp3.Callback;

/**
 * Created by guozhk on 16-8-3.
 */
public interface IGetData {
    void getTaskList(String simId,Callback callback);

    void getRecords(String simId,String startTime,String endTime,Callback callback);

    void getOrgIdBysim(String sim,Callback callback);
    void getChildOrg(String orgId,Callback callback);
    void getAreaList(String simCode,Callback callback);
    void startWork(String simCode, String lng, String lat, String simId, String remark,Callback callback);
    void finishWork(String simCode, String lng, String lat, String simId, String remark,Callback callback);
    void getAreaById(String areaId,Callback callback);
    void getUserInfo(String simCode,Callback callback);
    void getAlarmType(Callback callback);
    void changePWD(String simId, String oldPWD, String newPWD,Callback callback);
    void getAllUserInfo(String simCode, String type,Callback callback);
}
