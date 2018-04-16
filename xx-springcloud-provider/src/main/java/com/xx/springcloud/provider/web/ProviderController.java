package com.xx.springcloud.provider.web;
/******************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/8
 */
@RestController
@RequestMapping("/")
public class ProviderController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getInfoByBizId(@PathVariable String id) {

        return "getInfoByBizId form biz, id =" + id;
    }
}
