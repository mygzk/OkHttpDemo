package com.example.okhttpdemo.model.imodel;

import com.okhttp.libary.IProgressCallback;
import com.okhttp.libary.IRequestCallback;

/**
 * Created by guozhk on 16-8-3.
 */
public interface IGetData {
    void getTaskList(String simId, IRequestCallback callback);

    void getRecords(String simId, String startTime, String endTime, IRequestCallback callback);

    void getOrgIdBysim(String sim, IRequestCallback callback);

    void getChildOrg(String orgId, IRequestCallback callback);

    void getAreaList(String simCode, IRequestCallback callback);

    void startWork(String simCode, String lng, String lat, String simId, String remark, IRequestCallback callback);

    void finishWork(String simCode, String lng, String lat, String simId, String remark, IRequestCallback callback);

    void getAreaById(String areaId, IRequestCallback callback);

    void getUserInfo(String simCode, IRequestCallback callback);

    void getAlarmType(IRequestCallback callback);

    void changePWD(String simId, String oldPWD, String newPWD, IRequestCallback callback);

    void getAllUserInfo(String simCode, String type, IRequestCallback callback);

    void downTest(IProgressCallback callback);
    void uploadTest(IProgressCallback callback);
}
