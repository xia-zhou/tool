package com.cydeer.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * @author song.z
 * @date 2022/5/5 21:28
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface XzRequestParam {
    /**
     * 请求入参
     *
     * @return 请求入参
     */
    String value() default "";
}
