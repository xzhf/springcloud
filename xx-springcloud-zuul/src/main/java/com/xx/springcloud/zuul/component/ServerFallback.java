package com.xx.springcloud.zuul.component;

import com.xx.springcloud.zuul.bean.FallbackRespObj;
import com.xx.springcloud.zuul.bean.RestObj;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 代理熔断返回
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/25
 */
@Component
public class ServerFallback implements ZuulFallbackProvider {

    /**
     * @return serviceId, *、null表示全部
     */
    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return FallbackRespObj.ok(RestObj.fail("系统异常"), null);
    }
}
