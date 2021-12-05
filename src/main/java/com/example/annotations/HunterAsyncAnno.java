package com.example.annotations;

import java.lang.annotation.*;

/**
 * 异步执行方法的注解
 * AUTHOR: XIAOGUANYUE
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface HunterAsyncAnno {
    // 核心线程数
    int coreSize() default 1;

    // 最大核心线程数
    int maxSize() default 1;

}
