package com.xx.springcloud.consumer.component;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2018/4/26
 */
@Component
public class MsgConsumer {

    @KafkaListener(topics = {"springcloud-config-refresh"})
    public void consumer(ConsumerRecord record) {

        if (record != null) {
            Object obj = record.value();
            System.out.println(this.getClass().getName() + " consumer: " + JSONObject.toJSONString(obj));
            //TODO post /refresh
        }
    }
}
