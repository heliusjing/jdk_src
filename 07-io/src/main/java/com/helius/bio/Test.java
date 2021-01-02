package com.helius.bio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Helius
 * @Create 2020-07-02-10:38 下午
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("a.jpg");
//        FileOutputStream fos = new FileOutputStream("a2.jpg");
//
//        FileChannel channel1 = fis.getChannel();
//        FileChannel channel2 = fos.getChannel();
//
//        //使用transferFrom
//
//        channel2.transferFrom(channel1,0,channel1.size());
//
//        channel1.close();
//        channel2.close();
//
//        fis.close();
//        fos.close();


/*        ByteBuffer byteBuffer
                = ByteBuffer.allocate(64);

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        System.out.println(readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());

        }*/


        /**
         * MapperByteBuffer 可让文件直接在内存（堆外内存 ）修改，操作系统不需要拷贝一次
         */

        RandomAccessFile rw = new RandomAccessFile("1.txt", "rw");

        //获取对应的通道

        FileChannel channel = rw.getChannel();
        /**
         * 参数一：使用的读写模式
         * 参数2:可以修改的起始位置
         * 参数3:5是映射到内存的大小，即将1.txt的多少个字节映射到内存
         * 可以直接修改的范围就是0-5
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(3, (byte) 'H');

        rw.close();



    }
}
