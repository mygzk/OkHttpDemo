package com.example.okhttpdemo.bean;

/**
 * Created by guozhk on 16-8-15.
 */
public class LoginBean extends ResultBean<LoginBean>{
    private String result;
    private String msg;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
