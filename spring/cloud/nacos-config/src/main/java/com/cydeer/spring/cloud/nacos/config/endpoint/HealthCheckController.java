package com.cydeer.spring.cloud.nacos.config.endpoint;

import com.cydeer.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2022/1/30 9:40 下午
 */
@RestController
@RefreshScope
public class HealthCheckController {

    @Value("${demo.name}")
    private String name;

    @Autowired
    private Environment environment;

    @GetMapping({"/", "/health/readiness"})
    public Result<String> health() {
        String demoName = environment.getProperty("demo.name");
        return new Result<>("success:" + name + ":" + demoName);
    }
}
