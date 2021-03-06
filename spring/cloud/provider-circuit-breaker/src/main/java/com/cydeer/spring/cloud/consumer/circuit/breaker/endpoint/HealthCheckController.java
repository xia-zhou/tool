package com.cydeer.spring.cloud.consumer.circuit.breaker.endpoint;

import com.cydeer.common.Result;
import com.cydeer.spring.cloud.consumer.circuit.breaker.properties.DemoProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2022/1/30 9:40 下午
 */
@RestController
public class HealthCheckController {

    private final DemoProperties demoProperties;

    public HealthCheckController(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    @GetMapping({"/", "/health/readiness"})
    public Result<String> health() {
        return new Result<>("success");
    }
}
