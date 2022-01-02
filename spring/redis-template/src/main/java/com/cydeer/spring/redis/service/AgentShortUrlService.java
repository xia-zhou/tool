package com.cydeer.spring.redis.service;

import com.cydeer.spring.redis.domain.AgentShortUrl;
import com.cydeer.spring.redis.repository.AgentShortUrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author song.z
 * @date 2022/1/2 6:06 下午
 */
@Service
@Slf4j
public class AgentShortUrlService {

    private final AgentShortUrlRepository agentShortUrlRepository;

    private final StringRedisTemplate redisTemplate;

    private final RedisTemplate<String, AgentShortUrl> agentShortUrlRedisTemplate;


    public AgentShortUrlService(AgentShortUrlRepository agentShortUrlRepository, StringRedisTemplate redisTemplate,
                                RedisTemplate<String, AgentShortUrl> agentShortUrlRedisTemplate) {
        this.agentShortUrlRepository = agentShortUrlRepository;
        this.redisTemplate = redisTemplate;
        this.agentShortUrlRedisTemplate = agentShortUrlRedisTemplate;
    }


    public Optional<String> findById(Long id) {
        String url = redisTemplate.boundValueOps(id.toString()).get();
        if (StringUtils.hasText(url)) {
            return Optional.of(url);
        }
        Optional<AgentShortUrl> agentShortUrl = agentShortUrlRepository.findById(id);
        agentShortUrl.ifPresent(agent -> {
            redisTemplate.boundValueOps(id.toString()).set(agent.getShortUrl());
        });
        return agentShortUrl.map(AgentShortUrl::getShortUrl);
    }

    public Optional<AgentShortUrl> selectById(Long id) {
        AgentShortUrl agentShortUrl = agentShortUrlRedisTemplate.boundValueOps(id.toString()).get();
        if (agentShortUrl != null) {
            return Optional.of(agentShortUrl);
        }
        Optional<AgentShortUrl> agentShortUrlO = agentShortUrlRepository.findById(id);
        agentShortUrlO.ifPresent(agent -> {
            agentShortUrlRedisTemplate.boundValueOps(id.toString()).set(agent);
        });
        return agentShortUrlO;
    }
}
