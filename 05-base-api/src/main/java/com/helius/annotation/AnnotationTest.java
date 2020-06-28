package com.helius.annotation;

import java.lang.reflect.Method;

/**
 * @Author Helius
 * @Create 2020-05-27-12:33 上午
 */
public class AnnotationTest {
    @TestAnno("Hello World")
    public static void main(String[] args) {
        try {
            Class cls =  AnnotationTest.class;
            Method method = cls.getMethod("main", String[].class);
            TestAnno annotation = method.getAnnotation(TestAnno.class);
            System.out.println(annotation.value());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
