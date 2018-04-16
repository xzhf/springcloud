package com.xx.springcloud.provider.web;
/******************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/8
 */
@RestController
@RequestMapping("/")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Value("${provider.server}")
    private String consumerServer;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getInfoByBizId(@PathVariable String id) {
        String url = consumerServer + id;
        return restTemplate.getForObject(url, String.class);
    }
}
