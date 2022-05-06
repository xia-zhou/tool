package com.cydeer.biz.controller;

import com.cydeer.biz.service.DemoService;
import com.cydeer.spring.framework.annotation.XzAutowired;
import com.cydeer.spring.framework.annotation.XzController;
import com.cydeer.spring.framework.annotation.XzRequestMapping;
import com.cydeer.spring.framework.annotation.XzRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author song.z
 * @date 2022/5/5 21:37
 */
@XzController
@XzRequestMapping("/demo")
public class DemoController {

    @XzAutowired
    private DemoService demoService;


    @XzRequestMapping("/get")
    public String get(HttpServletRequest req, HttpServletResponse resp, @XzRequestParam("namet") String name) {
        return demoService.get(name);
    }

    @XzRequestMapping("/add")
    public String add(@XzRequestParam("name") String name) {
        return demoService.add(name);
    }


}
