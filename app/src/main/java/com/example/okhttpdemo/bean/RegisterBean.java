package com.example.okhttpdemo.bean;

/**
 * Created by guozhk on 16-8-8.
 */
public class RegisterBean {
    private int type;
    private String keycode;
    private String message;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
