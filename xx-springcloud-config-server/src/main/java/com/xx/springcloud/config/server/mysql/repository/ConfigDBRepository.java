package com.xx.springcloud.config.server.mysql.repository;

import com.xx.springcloud.config.server.mysql.entity.ConfigRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xuzhifan
 * @version 1.0
 * @since 2017/8/16
 */
@Repository
public interface ConfigDBRepository extends JpaRepository<ConfigRepository, Long> {

    ConfigRepository findFirstByApplicationAndProfileAndLabel (String application, String profile, String label);


}
