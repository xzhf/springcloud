package com.xx.springcloud.config.server.mysql.repository;
/******************************************************************************
 * Copyright (C) 2017 ShenZhen ComTop Information Technology Co.,Ltd
 * All Rights Reserved.
 * 本软件为深圳康拓普开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 ******************************************************************************/

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
