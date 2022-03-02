package com.cydeer.spring.cloud.consumer.circuit.breaker.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author song.z
 * @date 2022/2/28 10:43 下午
 */
@RefreshScope
@Data
@Component
@ConfigurationProperties("name")
public class DemoProperties {

    private String name;
}
