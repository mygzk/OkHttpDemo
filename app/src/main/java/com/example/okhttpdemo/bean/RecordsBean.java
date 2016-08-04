package com.example.okhttpdemo.bean;

import java.util.List;

/**
 * Created by guozhk on 16-8-4.
 */
public class RecordsBean {
    private String LONGITUDE;
    private String LATITUDE;
    private String BEGIN_TIME;
    private String STATUS;
    private List<RecordsBean> listBean;

    public String getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getBEGIN_TIME() {
        return BEGIN_TIME;
    }

    public void setBEGIN_TIME(String BEGIN_TIME) {
        this.BEGIN_TIME = BEGIN_TIME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public List<RecordsBean> getListBean() {
        return listBean;
    }

    public void setListBean(List<RecordsBean> listBean) {
        this.listBean = listBean;
    }
}
