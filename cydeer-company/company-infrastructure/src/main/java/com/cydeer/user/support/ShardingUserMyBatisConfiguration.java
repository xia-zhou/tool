package com.cydeer.user.support;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author song.z
 */
@Configuration
@MapperScan(value = {"com.cydeer.user.dal.sharding.mapper"}, sqlSessionFactoryRef = "shardingSqlSessionFactory")
public class ShardingUserMyBatisConfiguration {

    private final DataSource dataSource;

    public ShardingUserMyBatisConfiguration(@Qualifier("shardingUserDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean("shardingSqlSessionFactory")
    @Primary
    public SqlSessionFactory initSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/sharding/*.xml"));
        factoryBean.setTypeAliasesPackage(
                "com.cydeer.user.dal.sharding.dataobject,com.com.cydeer.user.dal.sharding.ext");
        return factoryBean.getObject();
    }

    @Bean("shardingTransactionManager")
    @Primary
    public DataSourceTransactionManager initDataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("shardingSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate initSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(initSqlSessionFactory());
    }

    @Bean("shardingTransactionTemplate")
    @Primary
    public TransactionTemplate initTransactionTemplate() {
        return new TransactionTemplate(initDataSourceTransactionManager());
    }

}