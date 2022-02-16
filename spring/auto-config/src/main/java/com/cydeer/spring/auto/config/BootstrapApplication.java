package com.cydeer.spring.auto.config;

import com.cydeer.spring.core.CoreBean;
import com.cydeer.spring.core.customer.config.CoreBeanAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author song.z
 */
@SpringBootApplication
@Import(CoreBeanAutoConfig.class)
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    @Bean
    public CoreBean coreBean() {
        return new CoreBean("你好");
    }
}
