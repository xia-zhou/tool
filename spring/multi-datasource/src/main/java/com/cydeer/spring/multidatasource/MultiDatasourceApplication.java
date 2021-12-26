package com.cydeer.spring.multidatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author song.z
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
                                  DataSourceTransactionManagerAutoConfiguration.class,
                                  JdbcTemplateAutoConfiguration.class})
@Slf4j
public class MultiDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("foo.datasource")
    public DataSourceProperties fooDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource fooDataSource() {
        DataSourceProperties fooDatasourceProperties = fooDatasourceProperties();
        log.info("foo url:{}", fooDatasourceProperties.getUrl());
        return fooDatasourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager fooPlatformTransactionManager(DataSource fooDataSource) {
        return new DataSourceTransactionManager(fooDataSource);
    }


    @Bean
    @ConfigurationProperties("bar.datasource")
    public DataSourceProperties barDatasourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource barDataSource() {
        DataSourceProperties barDatasourceProperties = barDatasourceProperties();
        log.info("bar url:{}", barDatasourceProperties.getUrl());
        return barDatasourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager barPlatformTransactionManager(DataSource barDataSource) {
        return new DataSourceTransactionManager(barDataSource);
    }
}
