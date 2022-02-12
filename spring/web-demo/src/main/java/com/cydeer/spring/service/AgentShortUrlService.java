package com.cydeer.spring.service;

import com.cydeer.spring.domain.AgentShortUrl;

/**
 * @author song.z
 * @date 2022/1/31 10:44 上午
 */
public interface AgentShortUrlService {
    /**
     * 获取短链
     *
     * @param id
     * @return 短链
     */
    AgentShortUrl get(Long id);
}
