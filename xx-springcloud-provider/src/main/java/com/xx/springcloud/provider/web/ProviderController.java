package com.xx.springcloud.provider.web;

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
