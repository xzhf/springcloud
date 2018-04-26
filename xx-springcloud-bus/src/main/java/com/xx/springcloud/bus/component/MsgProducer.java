package com.xx.springcloud.bus.component;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/26
 */
@Component
public class MsgProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMsg(Object obj) {
//        JSONObject.toJSONString(obj)
        kafkaTemplate.sendDefault(obj);
    }
}
