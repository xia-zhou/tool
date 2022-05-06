package com.cydeer.biz.service.impl;

import com.cydeer.biz.service.DemoService;
import com.cydeer.spring.framework.annotation.XzService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author song.z
 * @date 2022/5/5 21:35
 */
@XzService
public class DemoServiceImpl implements DemoService {

    private Map<String, String> data = new HashMap<>();

    @Override
    public String get(String name) {
        return "my name is " + data.get(name);
    }

    @Override
    public String add(String name) {
        data.put(name, "data:" + name);
        return name;
    }
}
