package com.example.okhttpdemo;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by guozhk on 16-8-8.
 */
public class GsonUtils {
    public static <T> T fromJson(String json, Type type) {
        if (json == null || "".equals(json)) {
            return null;
        }
        Gson gson = new Gson();
        try {
            return gson.fromJson(json, type);
        } catch (Exception ex) {
            Log.e(json + " 无法转换为 " +type + " ", ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args){
     /*   RegisterBean bean = fromJson(Constant.s,new TypeToken<RegisterBean>(){}.getType());
        try {
            JSONObject object = new JSONObject(Constant.S1);
            int errCode = object.optInt("errCode",-1);
            String errMsg = object.optString("errMsg",null);
            String result = object.optString("data",null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LoginBean bean1 = fromJson(Constant.S1,new TypeToken<LoginBean>(){}.getType());
        System.out.println("bean:"+bean.getMessage());*/
    }
}
