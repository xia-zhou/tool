package com.cydeer.spring.cloud.provider.endpoint;

import com.cydeer.common.Result;
import com.cydeer.spring.cloud.provider.domain.AgentShortUrl;
import com.cydeer.spring.cloud.provider.mapper.AgentShortUrlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.z
 * @date 2022/2/23 10:22 下午
 */
@RestController
public class ShortUrlController {


    private final AgentShortUrlMapper agentShortUrlMapper;

    public ShortUrlController(AgentShortUrlMapper agentShortUrlMapper) {
        this.agentShortUrlMapper = agentShortUrlMapper;
    }

    @GetMapping("/short/url/get")
    public Result<AgentShortUrl> findById(Long id) {
        return new Result<>(agentShortUrlMapper.selectByPrimaryKey(id));
    }

}
