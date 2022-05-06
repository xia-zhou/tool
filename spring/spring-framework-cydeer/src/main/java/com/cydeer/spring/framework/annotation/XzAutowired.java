package com.cydeer.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @author song.z
 * @date 2022/5/5 21:28
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XzAutowired {
    /**
     * 依赖的 bean 名称
     *
     * @return bean名称
     */
    String value() default "";
}
