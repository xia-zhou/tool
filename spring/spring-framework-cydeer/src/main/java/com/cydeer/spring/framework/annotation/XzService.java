package com.cydeer.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @author song.z
 * @date 2022/5/5 21:28
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XzService {
    /**
     * bean 名称
     *
     * @return bean名称
     */
    String value() default "";
}
