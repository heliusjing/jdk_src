package com.helius.bio;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author Helius
 * @Create 2020-07-02-11:53 下午
 */
public class FileChannelTest2 {
    public static void main(String[] args) {
        try {
            FileChannel.open(Paths.get("www.baidu.com"), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
