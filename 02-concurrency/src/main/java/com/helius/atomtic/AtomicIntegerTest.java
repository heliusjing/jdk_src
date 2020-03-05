package com.helius.atomtic;

import java.util.stream.IntStream;

/**
 * 线程安全再现：累加
 * 线程安全问题，使用AtomicInteger可以解决
 * @Author jcf
 * @Create 2020-02-07-22:42
 */
public class AtomicIntegerTest {
    private static int count = 0;

    public static void increment() {
        count++;
    }

    public static void main(String[] args) {
        IntStream.range(0, 100).forEach(i -> new Thread(() -> IntStream.range(0, 1000).forEach(j -> increment())).start());
        while (Thread.activeCount() > 2) {
            //
            Thread.yield();
        }
        System.out.println(count);
    }
}
