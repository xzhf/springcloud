package com.xx.springcloud.bus.web;

import com.xx.springcloud.bus.component.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/25
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private MsgProducer msgProducer;

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public String refresh() {

        msgProducer.sendMsg("refresh");
        return "true";
    }
}
