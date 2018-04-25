package com.xx.springcloud.zuul.bean;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.http.HttpStatus.OK;

/**
 * ServerFallback返回数据bean
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/25
 */
public class FallbackRespObj implements ClientHttpResponse {

    private HttpStatus status;

    private Object respData;

    private Map<String, String> headerMap;

    public FallbackRespObj(HttpStatus status, Object respData, Map<String, String> headerMap) {
        this.status = status;
        this.respData = respData;
        this.headerMap = headerMap;
    }

    public static FallbackRespObj ok(Object respData, Map<String, String> headerMap) {
        return new FallbackRespObj(OK, respData, headerMap);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }

    public Map<String, String> getHeaderMap() {
        return headerMap;
    }

    public void setHeaderMap(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return status;
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return status.value();
    }

    @Override
    public String getStatusText() throws IOException {
        return status.getReasonPhrase();
    }

    @Override
    public void close() {

    }

    @Override
    public InputStream getBody() throws IOException {

        if (respData == null) {
            respData = RestObj.fail("系统错误，请求失败");
        }
        return new ByteArrayInputStream(JSONObject.toJSONString(respData).getBytes("utf-8"));
    }

    @Override
    public HttpHeaders getHeaders() {

        HttpHeaders headers = new HttpHeaders();
        if (headerMap == null) {
            headerMap = new HashMap<>();
            headerMap.put("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        }
        for (String key : headerMap.keySet()) {
            headers.add(key, headerMap.get(key));
        }
        return headers;
    }


}
