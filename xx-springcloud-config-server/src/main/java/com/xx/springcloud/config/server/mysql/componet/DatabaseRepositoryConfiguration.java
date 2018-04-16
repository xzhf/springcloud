package com.xx.springcloud.config.server.mysql.componet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository;
import org.springframework.cloud.config.server.environment.SearchPathLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/16
 */
@Configuration
@ConditionalOnMissingBean(EnvironmentRepository.class)
@ConditionalOnProperty("spring.cloud.config.server.database")
public class DatabaseRepositoryConfiguration {

    @Autowired
    private ConfigurableEnvironment environment;

    @Bean
    public SearchPathLocator searchPathLocator () {

        return new NativeEnvironmentRepository(environment);
    }

    @Bean
    @Primary
    public EnvironmentRepository openEnvironmentRepository() {

        return new DbEnvRepository();
    }
}
