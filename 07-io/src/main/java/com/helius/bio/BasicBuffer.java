package com.helius.bio;

import java.nio.IntBuffer;

/**
 * @Author Helius
 * @Create 2020-07-01-10:47 下午
 */
public class BasicBuffer {
    public static void main(String[] args) {
        //Buffer使用
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //向buffer中放数据
//        intBuffer.put(10);
//        intBuffer.put(11);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        //如何从buffer读取数据
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
