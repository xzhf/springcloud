package com.xx.springcloud.config.server.mysql.entity;

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
