package com.cydeer.spring.auto.config;

import com.cydeer.spring.core.CoreBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author song.z
 */
@SpringBootApplication
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    @Bean
    public CoreBean coreBean() {
        return new CoreBean("你好");
    }
}
