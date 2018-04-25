package com.xx.springcloud.zuul.bean;

import com.alibaba.fastjson.JSONObject;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * rest api返回数据bean
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/25
 */
public class RestObj {

    private int code;

    private String msg;

    private Object data;

    public static RestObj fail(String msg) {
        return new RestObj(500, msg, null);
    }

    public static RestObj tokenFail() {

        return new RestObj(UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase(), null);
    }

    public RestObj() {
    }

    public RestObj(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
