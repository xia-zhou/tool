package com.cydeer.biz.service;

/**
 * @author song.z
 * @date 2022/5/5 21:34
 */
public interface DemoService {

    /**
     * 获取名称
     *
     * @param name 参数
     * @return 名称
     */
    String get(String name);

    /**
     * 添加名称
     *
     * @param name 名称
     * @return 添加结果
     */
    String add(String name);
}
