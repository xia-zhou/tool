package com.cydeer.spring.cloud.consumer.service;

import com.cydeer.common.Result;
import com.cydeer.spring.cloud.consumer.domain.AgentShortUrl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author song.z
 * @date 2022/2/23 10:21 下午
 */
@FeignClient(name = "provider", contextId = "short")
public interface TestService {

    /**
     * 根据id获取短链
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/short/url/get", params = "id")
    Result<AgentShortUrl> findById(@RequestParam("id") Long id);
}
