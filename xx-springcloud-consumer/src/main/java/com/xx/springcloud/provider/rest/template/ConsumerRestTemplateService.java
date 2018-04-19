package com.xx.springcloud.provider.rest.template;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/17
 */
@RefreshScope
@Service
public class ConsumerRestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.server}")
    private String consumerServer;

    @HystrixCommand(fallbackMethod = "error")
    public String getInfoById(String id) {

        //地址要加上provider的context
        String url = consumerServer + id;
        return restTemplate.getForObject(url, String.class);
    }

    private String error(String id) {
        return "waiting...";
    }
}
