package com.aviation.util;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //100-success,200-fail
    private int code;

    //提示信息
    private String msginfo;

    //数据
    private Map<String, Object> info = new HashMap<String, Object>();

    public static Msg success(String msginfo) {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsginfo(msginfo);
        return result;
    }

    public static Msg fail(String msginfo) {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsginfo(msginfo);
        return result;
    }

    public Msg add(String key, Object value) {
        this.getInfo().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsginfo() {
        return msginfo;
    }

    public void setMsginfo(String msginfo) {
        this.msginfo = msginfo;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }
}
