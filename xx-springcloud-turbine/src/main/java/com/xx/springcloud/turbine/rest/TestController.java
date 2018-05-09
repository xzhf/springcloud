package com.xx.springcloud.turbine.rest;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/5/7
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public Object test(String id) {

        return discoveryClient.getInstances(id);
    }
}
