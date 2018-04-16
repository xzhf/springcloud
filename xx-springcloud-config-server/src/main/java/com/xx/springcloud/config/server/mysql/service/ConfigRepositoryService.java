package com.xx.springcloud.config.server.mysql.service;


import com.xx.springcloud.config.server.mysql.entity.ConfigRepository;
import com.xx.springcloud.config.server.mysql.repository.ConfigDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/16
 */
@Service
public class ConfigRepositoryService {

    @Autowired
    private ConfigDBRepository configDBRepository;

    public ConfigRepository find (String application, String profile, String label) {

        return configDBRepository.findFirstByApplicationAndProfileAndLabel(application, profile, label);
    }
}
