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
@MapperScan(value = {"com.cydeer.user.dal.common.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class UserMyBatisConfiguration {

    private final DataSource dataSource;

    public UserMyBatisConfiguration(@Qualifier("userDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory initSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/common/*.xml"));
        factoryBean.setTypeAliasesPackage("com.cydeer.user.dal.common.dataobject,com.com.cydeer.user.dal.common.ext");
        return factoryBean.getObject();
    }

    @Bean("transactionManager")
    @Primary
    public DataSourceTransactionManager initDataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate initSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(initSqlSessionFactory());
    }

    @Bean("transactionTemplate")
    @Primary
    public TransactionTemplate initTransactionTemplate() {
        return new TransactionTemplate(initDataSourceTransactionManager());
    }

}