package com.cydeer.biz.controller;

import com.cydeer.biz.service.DemoService;
import com.cydeer.spring.framework.annotation.XzAutowired;
import com.cydeer.spring.framework.annotation.XzController;
import com.cydeer.spring.framework.annotation.XzRequestMapping;
import com.cydeer.spring.framework.annotation.XzRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void get(HttpServletRequest req, HttpServletResponse resp, @XzRequestParam("namet") String name) {
        try {
            resp.getWriter().write(demoService.get(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @XzRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse resp, @XzRequestParam("name") String name) {
        try {
            resp.getWriter().write(demoService.add(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
