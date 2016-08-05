package com.okhttp.libary;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by guozhk on 16-8-4.
 */
public class GsonUtils {
    public static <T> T fromJson(String json, TypeToken<T> token) {
        if (json == null || "".equals(json)) {
            return null;
        }
        Gson gson = new Gson();
        try {
            return gson.fromJson(json, token.getType());
        } catch (Exception ex) {
            Log.e(json + " 无法转换为 " + token.getRawType().getName() + " 对象!", ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
}
