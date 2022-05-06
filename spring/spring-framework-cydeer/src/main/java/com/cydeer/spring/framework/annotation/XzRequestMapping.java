package com.cydeer.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @author song.z
 * @date 2022/5/5 21:28
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XzRequestMapping {
    /**
     * url 路径
     *
     * @return url路径
     */
    String value() default "";
}
