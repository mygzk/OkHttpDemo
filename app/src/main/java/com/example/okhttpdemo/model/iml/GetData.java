package com.example.okhttpdemo.model.iml;

import com.example.okhttpdemo.Constant;
import com.example.okhttpdemo.model.imodel.IGetData;
import com.okhttp.libary.IProgressCallback;
import com.okhttp.libary.IRequestCallback;
import com.okhttp.libary.OkHttpManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guozhk on 16-8-3.
 */
public class GetData implements IGetData {
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private Map<String, Object> params = new HashMap<>();

    @Override
    public void getTaskList(String simId, IRequestCallback callback) {
        clearParams();
        params.put("sim", simId);
        okHttpManager.post(Constant.TASK_LIST).params(params).build().enqueue(callback);
    }


    @Override
    public void getRecords(String simId, String startTime, String endTime, IRequestCallback callback) {
        clearParams();
        params.put("simCode", simId);
        params.put("startTime", startTime);
        params.put("endTime", endTime);
        okHttpManager.post(Constant.RECORDS).params(params).build().enqueue(callback);
    }

    @Override
    public void getOrgIdBysim(String sim, IRequestCallback callback) {
        clearParams();
        params.put("sim", sim);
        okHttpManager.post(Constant.getOrgIdBysim).params(params).build().enqueue(callback);
    }

    @Override
    public void getChildOrg(String orgId, IRequestCallback callback) {
        clearParams();
        params.put("orgId", orgId);
        okHttpManager.post(Constant.getChildOrg).params(params).build().enqueue(callback);
    }

    @Override
    public void getAreaList(String simCode, IRequestCallback callback) {
        clearParams();
        params.put("simCode", simCode);
        okHttpManager.post(Constant.getAreaList).params(params).build().enqueue(callback);
    }

    @Override
    public void startWork(String simCode, String lng, String lat, String simId, String remark, IRequestCallback callback) {
        clearParams();
        params.put("simCode", simCode);
        params.put("lng", lng);
        params.put("lat", lat);
        params.put("simId", simId);
        params.put("remark", remark);
        okHttpManager.post(Constant.startWork).params(params).build().enqueue(callback);
    }

    @Override
    public void finishWork(String simCode, String lng, String lat, String simId, String remark, IRequestCallback callback) {
        clearParams();
        params.put("simCode", simCode);
        params.put("lng", lng);
        params.put("lat", lat);
        params.put("simId", simId);
        params.put("remark", remark);
        okHttpManager.post(Constant.finishWork).params(params).build().enqueue(callback);
    }

    @Override
    public void getAreaById(String areaId, IRequestCallback callback) {
        clearParams();
        params.put("areaId", areaId);
        okHttpManager.post(Constant.getAreaById).params(params).build().enqueue(callback);
    }

    @Override
    public void getUserInfo(String simCode, IRequestCallback callback) {
        clearParams();
        params.put("simCode", simCode);
        okHttpManager.post(Constant.getUserInfo).params(params).build().enqueue(callback);
    }

    @Override
    public void getAlarmType(IRequestCallback callback) {
        okHttpManager.post(Constant.getAlarmType).build().enqueue(callback);
    }

    @Override
    public void changePWD(String simId, String oldPWD, String newPWD, IRequestCallback callback) {
        clearParams();
        params.put("simId", simId);
        params.put("oldPWD", oldPWD);
        params.put("newPWD", newPWD);
        okHttpManager.post(Constant.changePWD).params(params).build().enqueue(callback);
    }

    @Override
    public void getAllUserInfo(String simCode, String type, IRequestCallback callback) {
        clearParams();
        params.put("simCode", simCode);
        params.put("type", type);
        okHttpManager.post(Constant.getAllUserInfo).params(params).build().enqueue(callback);
    }

    private void clearParams() {
        params.clear();
    }


    @Override
    public void downTest(IProgressCallback callback) {
        okHttpManager.down(Constant.downUrl, "/sdcard", "test.apk").buidRequest().enqueue(callback);
    }

    @Override
    public void uploadTest(IProgressCallback callback) {
        clearParams();
        params.put("simCode", "15021362837");
        params.put("type", "12");
        String filepath1 = "/sdcard/1.jpg";
        String filepath2 = "/sdcard/2.jpg";
        String filepath3 = "/sdcard/7.txt";
        String filepath4 = "/sdcard/test.apk";
        File file1 = new File(filepath1);
        File file2 = new File(filepath2);
        File file3 = new File(filepath3);
        File file4 = new File(filepath4);
       /* if (file1.exists()) {
            params.put("file1", file1);
        }*/
      /*  if (file2.exists()) {
            params.put("file2", file2);
        }*/
        if (file3.exists()) {
            params.put("file3", file3);
        }
        /*if (file4.exists()) {
            params.put("file4", file4);
        }
*/

        okHttpManager.post(Constant.upload).params(params).build().enqueue(callback);
    }
}
