package com.helius.character6;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author Helius
 * @Create 2020-08-01-4:11 下午
 */
public class MyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
/*        String classpath = "/Users/helius/develper/classloader";
        TestClassLoader testClassLoader = new TestClassLoader(classpath);
        Class<?> object = testClassLoader.findClass("ClassLoaderTest");
        System.out.println(object.getClassLoader());*/


        URL[] urls = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

    }
}
