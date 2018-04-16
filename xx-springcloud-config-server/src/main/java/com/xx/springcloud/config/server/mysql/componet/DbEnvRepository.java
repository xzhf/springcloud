package com.xx.springcloud.config.server.mysql.componet;

import com.xx.springcloud.config.server.mysql.entity.ConfigProperties;
import com.xx.springcloud.config.server.mysql.entity.ConfigRepository;
import com.xx.springcloud.config.server.mysql.service.ConfigRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.util.StringUtils;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/16
 */
public class DbEnvRepository implements EnvironmentRepository {

    @Autowired
    private ConfigRepositoryService configRepositoryService;

    @Override
    public Environment findOne(String app, String profile, String label) {

        if (StringUtils.isEmpty(app) || StringUtils.isEmpty(profile)) {
            return null;
        }
        ConfigRepository repository = configRepositoryService.find(app, profile, label);
        if (repository != null ) {
            Environment environment = new Environment(app, profile, label, repository.getVersion());
            for (ConfigProperties proper : repository.getConfigPropertiesList()) {
                environment.add(new PropertySource(proper.getPropertiesName(), proper.getContent()));
            }
            return environment;
        }
        return new Environment(app, profile);
    }
}
