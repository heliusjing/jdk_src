package com.helius.file;

import java.io.File;

/**
 * @Author Helius
 * @Create 2020-02-26-14:03
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("d:/migu");
        file.mkdir();
        if (file.exists()&&file.isDirectory()){
            System.out.println("migu目录存在");
        }
    }
}
