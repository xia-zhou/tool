package com.cydeer.spring.redis;

import com.cydeer.spring.redis.mapper.AgentShortUrlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author song.z
 */
@SpringBootApplication
@Slf4j
public class RedisApplication implements CommandLineRunner {


    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private AgentShortUrlMapper agentShortUrlMapper;

    @Bean
    @ConfigurationProperties("spring.redis.jedis.pool")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${spring.redis.host}") String host) {
        return new JedisPool(jedisPoolConfig(), host);
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Jedis jedis = jedisPool.getResource()) {
            agentShortUrlMapper.listAll().forEach(agentShortUrl -> {

                jedis.set(agentShortUrl.getId().toString(), agentShortUrl.getShortUrl());
            });
            log.info("id:{},shortUrl:{}", 1, jedis.get("1"));
            log.info("id:{},shortUrl:{}", 2, jedis.get("2"));
            log.info("id:{},shortUrl:{}", 2, jedis.get("3"));
        }
    }
}
