package com.xx.springcloud.config.server.mysql.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/16
 */
@Entity
@Table(name = "config_properties")
public class ConfigProperties {

    @Id
    @GeneratedValue
    private Long propertiesKey;

    private String propertiesName;

    //客户端直接根据content里面的key来获取对应的value
    @Lob
    @Column
    @Type(type = "com.xx.springcloud.config.server.mysql.componet.JsonType")
    private Map<String, String> content = new HashMap<>();

    public Long getPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(Long propertiesKey) {
        this.propertiesKey = propertiesKey;
    }


    public String getPropertiesName() {
        return propertiesName;
    }

    public void setPropertiesName(String propertiesName) {
        this.propertiesName = propertiesName;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }
}
