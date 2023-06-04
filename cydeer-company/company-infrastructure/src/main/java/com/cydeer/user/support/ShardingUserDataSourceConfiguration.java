package com.cydeer.user.support;

import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @author chentao 2019-07-22
 */

@Configuration
public class ShardingUserDataSourceConfiguration {

    private final DataSource dataSource;

    private final static String DATA_SOURCE_ALISA = "user_ds";

    public ShardingUserDataSourceConfiguration(@Qualifier("userDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean(value = "shardingUserDataSource")
    public DataSource shardingDataSource() throws SQLException {
        // 对最初的数据源起一个别名，主要用于分库情况下，多个库的存放
        Map<String, DataSource> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(DATA_SOURCE_ALISA, dataSource);
        return ShardingSphereDataSourceFactory.createDataSource(dataSourceMap,
                                                                Collections.singleton(shardingRuleConfiguration()),
                                                                new Properties());
    }


    @Bean
    public ShardingRuleConfiguration shardingRuleConfiguration() {
        ShardingRuleConfiguration result = new ShardingRuleConfiguration();
        // 用户分表配置
        result.getTables().add(userShardingTableRuleConfiguration());
        Properties userAlgorithmProperties = new Properties();
        userAlgorithmProperties.setProperty("algorithm-expression",
                                            "user_$->{sprintf('%03d', Long.valueOf(uid) % 128)}");
        result.getShardingAlgorithms().put("uid_inline", new AlgorithmConfiguration("INLINE", userAlgorithmProperties));

        // openId分表配置
        result.getTables().add(openIdShardingTableRuleConfiguration());
        // openId根据什么来做分表的配置
        Properties openIdAlgorithmProperties = new Properties();
        openIdAlgorithmProperties.setProperty("algorithm-expression",
                                              "openid_user_relation_$->{sprintf('%03d', java.lang.Math.abs(open_id.hashCode()) % 128)}");
        result.getShardingAlgorithms().put("open_id_inline",
                                           new AlgorithmConfiguration("INLINE", openIdAlgorithmProperties));
        return result;
    }

    @Bean
    public ShardingTableRuleConfiguration userShardingTableRuleConfiguration() {
        ShardingTableRuleConfiguration result = new ShardingTableRuleConfiguration("user",
                                                                                   DATA_SOURCE_ALISA + ".user_$->{(0..127).collect{sprintf('%03d', it)}}");
        result.setTableShardingStrategy(new StandardShardingStrategyConfiguration("uid", "uid_inline"));
        return result;
    }

    /**
     * openId分表的基本条件
     *
     * @return
     */
    @Bean
    public ShardingTableRuleConfiguration openIdShardingTableRuleConfiguration() {
        ShardingTableRuleConfiguration result = new ShardingTableRuleConfiguration("openid_user_relation",
                                                                                   DATA_SOURCE_ALISA + ".openid_user_relation_$->{(0..127).collect{sprintf('%03d', it)}}");
        result.setTableShardingStrategy(new StandardShardingStrategyConfiguration("open_id", "open_id_inline"));
        return result;
    }
}