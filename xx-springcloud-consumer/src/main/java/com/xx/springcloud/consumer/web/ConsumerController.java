package com.xx.springcloud.consumer.web;

import com.xx.springcloud.consumer.feign.ConsumerFeignClient;
import com.xx.springcloud.consumer.rest.template.ConsumerRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/8
 */
@RestController
@RequestMapping("/")
public class ConsumerController {


    @Autowired
    private ConsumerFeignClient feignClient;
    @Autowired
    private ConsumerRestTemplateService restTempService;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)
    public String getByRestTmp(@PathVariable String id) {

        return restTempService.getInfoById(id);
    }

    @RequestMapping(value = "/feign/{id}", method = RequestMethod.GET)
    public String getByFeignClient(@PathVariable String id) {

        return feignClient.getInfoById(id);
    }


}
