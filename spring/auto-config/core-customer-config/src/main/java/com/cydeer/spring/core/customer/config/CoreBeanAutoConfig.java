package com.cydeer.spring.core.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author song.z
 * @date 2022/2/16 10:11 下午
 */
@Configuration
public class CoreBeanAutoConfig {

    @Bean
    public CoreBeanFactoryProcessor coreBeanFactoryProcessor() {
        return new CoreBeanFactoryProcessor();
    }

}
