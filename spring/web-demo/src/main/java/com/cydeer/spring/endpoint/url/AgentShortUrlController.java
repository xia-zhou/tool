package com.cydeer.spring.endpoint.url;

import com.alibaba.fastjson.JSON;
import com.cydeer.common.Result;
import com.cydeer.spring.domain.AgentShortUrl;
import com.cydeer.spring.service.AgentShortUrlService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author song.z
 * @date 2022/1/31 10:46 上午
 */
@RestController
public class AgentShortUrlController {

    private final AgentShortUrlService agentShortUrlService;

    public AgentShortUrlController(AgentShortUrlService agentShortUrlService) {
        this.agentShortUrlService = agentShortUrlService;
    }

    @GetMapping("/demo/short/url/get")
    public Result<AgentShortUrl> get(@RequestParam(value = "id") Long id) {
        return new Result<>(agentShortUrlService.get(id));
    }

    @GetMapping("/demo/short/url/localDateTime")
    public Result<LocalDateTime> localDateTime(LocalDateTime time) {
        return new Result<>(time);
    }

    @GetMapping("/demo/short/url/localDate")
    public Result<LocalDate> localDate(LocalDate time) {
        return new Result<>(time);
    }

    @PostMapping("/demo/short/url/form")
    public Result<AgentShortUrl> save(AgentShortUrl agentShortUrl) {
        agentShortUrl.setName(JSON.toJSONString(agentShortUrl));
        return new Result<>(agentShortUrl);
    }

    @PostMapping("/demo/short/url/json")
    public Result<AgentShortUrl> saveJson(@RequestBody AgentShortUrl agentShortUrl) {
        agentShortUrl.setName(JSON.toJSONString(agentShortUrl));
        return new Result<>(agentShortUrl);
    }

}
