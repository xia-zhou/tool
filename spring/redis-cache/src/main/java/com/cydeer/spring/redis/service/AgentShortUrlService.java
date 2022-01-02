package com.cydeer.spring.redis.service;

import com.cydeer.spring.redis.domain.AgentShortUrl;
import com.cydeer.spring.redis.repository.AgentShortUrlRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author song.z
 * @date 2022/1/1 11:22 下午
 */
@Service
@CacheConfig(cacheNames = "shortUrl")
public class AgentShortUrlService {

    private final AgentShortUrlRepository agentShortUrlRepository;

    public AgentShortUrlService(AgentShortUrlRepository agentShortUrlRepository) {
        this.agentShortUrlRepository = agentShortUrlRepository;
    }

    @Cacheable
    public List<AgentShortUrl> list() {
        return agentShortUrlRepository.findAll();
    }

    @Cacheable
    public Optional<AgentShortUrl> selectById(Long i) {
        return agentShortUrlRepository.findById(i);
    }
}
