package com.cydeer.spring.cloud.consumer.circuit.breaker.endpoint;

import com.alibaba.fastjson.JSON;
import com.cydeer.boot.starter.util.http.HttpUtils;
import com.cydeer.common.Result;
import com.cydeer.spring.cloud.consumer.circuit.breaker.domain.AgentShortUrl;
import com.cydeer.spring.cloud.consumer.circuit.breaker.service.TestService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2022/2/23 10:26 下午
 */
@RestController
@Slf4j
public class ShortUrlController {

    private final TestService testService;

    private final DiscoveryClient discoveryClient;

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public ShortUrlController(TestService testService, DiscoveryClient discoveryClient,
                              CircuitBreakerRegistry circuitBreakerRegistry) {
        this.testService = testService;
        this.discoveryClient = discoveryClient;
        this.circuitBreakerRegistry = circuitBreakerRegistry;
    }

    @GetMapping("/agent/url/get")
    public Result<AgentShortUrl> get(Long id) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("cydeer");
        return circuitBreaker.executeSupplier(() -> testService.findById(id));
    }

    public String getDefault(Long id, Throwable tracerThrowable) {
        log.info("getDefault id:{}", id);
        return JSON.toJSONString(new Result<>(new AgentShortUrl()));
    }

    @GetMapping("/agent/url/get1")
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "cydeer", fallbackMethod = "getDefault")
    public String get1(Long id) {
        return HttpUtils.get(discoveryClient.getInstances("provider")
                                     .get(0)
                                     .getUri()
                                     .toString() + "/short/url/get?id=" + id).executeAsString();
    }
}
