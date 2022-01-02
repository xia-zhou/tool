package com.cydeer.spring.redis;

import com.cydeer.spring.redis.service.AgentShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author song.z
 */
@SpringBootApplication
public class RedisTemplateApplication implements CommandLineRunner {

    @Autowired
    private AgentShortUrlService agentShortUrlService;


    public static void main(String[] args) {
        SpringApplication.run(RedisTemplateApplication.class, args);
    }


    @Bean
    public LettuceConnectionFactory jedisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public <T> RedisTemplate<String, T> agentShortUrlRedisTemplate() {
        RedisTemplate<String, T> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.json());
        return redisTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        agentShortUrlService.findById(3L);
        agentShortUrlService.selectById(4L);
    }
}
