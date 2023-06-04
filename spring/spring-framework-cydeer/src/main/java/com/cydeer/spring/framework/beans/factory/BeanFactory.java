package com.cydeer.spring.framework.beans.factory;

/**
 * @author song.z
 * @date 2022/5/6 21:23
 */
public interface BeanFactory {


    /**
     * 获取bean
     *
     * @param name bean name
     * @return bean
     */
    Object getBean(String name);

    /**
     * @param name         bean 名称
     * @param requiredType bean类型
     * @param <T>          范型参数
     * @return bean
     */
    <T> T getBean(String name, Class<T> requiredType);
}
