package com.xx.springcloud.config.server.mysql.entity;
/******************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/16
 */
@Entity
@Table(name = "config_repository")
public class ConfigRepository {

    @Id
    @GeneratedValue
    private Long configKey;
    private String application; //应用名称
    private String profile;//应用模块
    private String label;//应用环境
    private String version; //应用版本

    @ManyToMany
    @JoinTable(name = "config_properties_repository")
    private List<ConfigProperties> configPropertiesList = new ArrayList<>();

    public Long getConfigKey() {
        return configKey;
    }

    public void setConfigKey(Long configKey) {
        this.configKey = configKey;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ConfigProperties> getConfigPropertiesList() {
        return configPropertiesList;
    }

    public void setConfigPropertiesList(List<ConfigProperties> configPropertiesList) {
        this.configPropertiesList = configPropertiesList;
    }
}
