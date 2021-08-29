package com.example.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MytrixAnno {
    int value() default 100;
    String fallback() default "";
}
