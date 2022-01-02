package com.cydeer.spring.redis;

import com.cydeer.spring.redis.domain.AgentShortUrl;
import com.cydeer.spring.redis.service.AgentShortUrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Optional;

/**
 * @author song.z
 */
@SpringBootApplication
@Slf4j
@EnableCaching(proxyTargetClass = true)
public class RedisCacheApplication implements CommandLineRunner {

    @Autowired
    private AgentShortUrlService agentShortUrlService;

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<AgentShortUrl> url = agentShortUrlService.selectById(1L);
        log.info("url:{}", url.orElse(null));
        log.info("-=========");
        url = agentShortUrlService.selectById(1L);
        log.info("url:{}", url.orElse(null));
    }
}
