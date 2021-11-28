package com.example.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface MyAnnotation {

    String value() default "";

}