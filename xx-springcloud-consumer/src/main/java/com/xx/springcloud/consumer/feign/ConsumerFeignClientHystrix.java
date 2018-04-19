package com.xx.springcloud.consumer.feign;

import org.springframework.stereotype.Component;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/17
 */
@Component
public class ConsumerFeignClientHystrix implements ConsumerFeignClient {

    @Override
    public String getInfoById(String id) {
        return "waiting...";
    }
}
