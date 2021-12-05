package com.example.annotations;

import java.lang.annotation.*;

/**
 *  定义一个普通注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HunterLogAnno {
    String value() default "";
}
