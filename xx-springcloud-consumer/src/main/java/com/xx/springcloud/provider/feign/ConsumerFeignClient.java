package com.xx.springcloud.provider.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/17
 */
@FeignClient(name = "provider", fallback = ConsumerFeignClientHystrix.class)
public interface ConsumerFeignClient {

    //@PathVariable(value = "id") 注解要有value 不然报错；地址要加上provider的context
    @RequestMapping(value = "/provider/{id}", method = RequestMethod.GET)
    String getInfoById(@PathVariable(value = "id") String id);
}
