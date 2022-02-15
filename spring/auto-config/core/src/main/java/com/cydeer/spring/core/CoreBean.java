package com.cydeer.spring.core;

/**
 * @author song.z
 * @date 2022/2/15 10:41 下午
 */
public class CoreBean {

    private String name;

    public CoreBean() {
        this.name = "default";
    }

    public CoreBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
