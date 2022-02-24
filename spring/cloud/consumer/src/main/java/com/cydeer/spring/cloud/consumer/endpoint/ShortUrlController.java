package com.cydeer.spring.cloud.consumer.endpoint;

import com.cydeer.boot.starter.util.http.HttpUtils;
import com.cydeer.common.Result;
import com.cydeer.spring.cloud.consumer.domain.AgentShortUrl;
import com.cydeer.spring.cloud.consumer.service.TestService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2022/2/23 10:26 下午
 */
@RestController
public class ShortUrlController {

    private final TestService testService;

    private final DiscoveryClient discoveryClient;

    public ShortUrlController(TestService testService, DiscoveryClient discoveryClient) {
        this.testService = testService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/agent/url/get")
    public Result<AgentShortUrl> get(Long id) {
        return testService.findById(id);
    }

    @GetMapping("/agent/url/get1")
    public String get1(Long id) {
        return HttpUtils.get(discoveryClient.getInstances("provider")
                                     .get(0)
                                     .getUri()
                                     .toString() + "/short/url/get?id=" + id).executeAsString();
    }
}
