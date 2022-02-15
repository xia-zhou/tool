package com.cydeer.spring.core.config;

import com.cydeer.spring.core.CoreBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author song.z
 * @date 2022/2/15 10:45 下午
 */
@Configuration
@ConditionalOnClass(CoreBean.class)
public class CoreBeanAuthConfig {

    @Bean
    @ConditionalOnMissingBean(CoreBean.class)
    public CoreBean coreBean() {
        return new CoreBean();
    }

}
