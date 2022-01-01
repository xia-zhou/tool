package com.cydeer.mybatis.mybatis.endpoint;

import com.cydeer.mybatis.mybatis.domain.AgentShortUrl;
import com.cydeer.mybatis.mybatis.mapper.AgentShortUrlMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author song.z
 * @date 2022/1/1 4:06 下午
 */
@RestController
public class AgentShortUrlController {


    private final AgentShortUrlMapper agentShortUrlMapper;

    public AgentShortUrlController(AgentShortUrlMapper agentShortUrlMapper) {
        this.agentShortUrlMapper = agentShortUrlMapper;
    }

    @GetMapping("/agent/short/url/list")
    public PageInfo<AgentShortUrl> list() {
        PageHelper.startPage(1, 10);
        List<AgentShortUrl> list = agentShortUrlMapper.listAll();
        PageInfo<AgentShortUrl> pageInfo = new PageInfo<>(list);
        return PageHelper.startPage(1, 3).doSelectPageInfo(() -> agentShortUrlMapper.listAll());
    }

}
