package com.cydeer.spring.redis.repository;

import com.cydeer.spring.redis.domain.AgentShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author song.z
 * @date 2022/1/1 11:13 下午
 */
public interface AgentShortUrlRepository extends JpaRepository<AgentShortUrl, Long> {}
