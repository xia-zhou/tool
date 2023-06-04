package com.cydeer.user.support;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chentao 2019-07-22
 */

@Configuration
public class UserDataSourceConfiguration {

    @Bean(value = "userDataSource")
    @ConfigurationProperties(prefix = "spring.xz.datasource.primary")
    public DataSource marketingDatasource() {
        return new DruidDataSource();
    }

}