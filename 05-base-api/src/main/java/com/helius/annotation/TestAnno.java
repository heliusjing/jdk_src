package com.helius.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

/**
 * @Author Helius
 * @Create 2020-05-27-12:32 上午
 */
@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnno {
    String value() default "abc";
}
