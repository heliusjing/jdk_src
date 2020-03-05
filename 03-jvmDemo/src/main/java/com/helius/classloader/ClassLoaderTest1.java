package com.helius.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Author jcf
 * @Create 2020-02-09-22:57
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        //获取加载路径
        System.out.println("***********启动类加载器*************");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

    }
}
