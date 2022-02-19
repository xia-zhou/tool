package com.cydeer.spring.custom.web.endpoint;

import com.cydeer.common.Result;
import com.cydeer.spring.custom.web.domain.AgentShortUrl;
import com.cydeer.spring.custom.web.mapper.AgentShortUrlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author song.z
 * @date 2022/2/19 8:43 下午
 */
@RestController
public class HelloController {

    private final AgentShortUrlMapper agentShortUrlMapper;


    public HelloController(AgentShortUrlMapper agentShortUrlMapper) {
        this.agentShortUrlMapper = agentShortUrlMapper;
    }

    @GetMapping("/agent/short/url/list")
    public Result<List<AgentShortUrl>> listAll() {
        return new Result<>(agentShortUrlMapper.listAll());
    }
}
