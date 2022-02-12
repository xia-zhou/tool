package com.cydeer.spring.service.impl;

import com.cydeer.common.CommonException;
import com.cydeer.common.util.constant.CommonErrorCode;
import com.cydeer.spring.domain.AgentShortUrl;
import com.cydeer.spring.mapper.AgentShortUrlMapper;
import com.cydeer.spring.service.AgentShortUrlService;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author song.z
 * @date 2022/1/31 10:44 上午
 */
@Service
public class AgentShortUrlServiceImpl implements AgentShortUrlService {

    private final AgentShortUrlMapper agentShortUrlMapper;


    public AgentShortUrlServiceImpl(AgentShortUrlMapper agentShortUrlMapper) {
        this.agentShortUrlMapper = agentShortUrlMapper;
    }


    @Override
    public AgentShortUrl get(Long id) {
        if (Objects.equals(id, 3L)) {
            throw new CommonException(CommonErrorCode.PARAM_ERROR);
        }
        return agentShortUrlMapper.selectByPrimaryKey(id);
    }
}
