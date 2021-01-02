package com.helius.bio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author Helius
 * @Create 2020-06-29-10:22 下午
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("/Users/helius/development/idea_workspace/jdk_src/07-io/src/main/java/com/helius/bio/number.txt"), "rw");
//        long length = raf.length();
//        System.out.println(length);
//        System.out.println(raf.getFilePointer());
//        raf.seek(5);
//        System.out.println(raf.getFilePointer());
//        raf.write(2);
//        raf.write("hello".getBytes("utf8"));
        raf.writeByte(5);
    }
}
