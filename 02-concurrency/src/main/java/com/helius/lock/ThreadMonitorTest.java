package com.helius.lock;

import org.junit.Test;

/**
 * @Author jcf
 * @Create 2020-02-20-13:38
 */
public class ThreadMonitorTest {

    Object o = new Object();

    @Test
    public void test1() throws Exception {
        new Thread(() -> {
            synchronized(o) {
                System.out.println("child thread: holdLock: " +
                        Thread.holdsLock(o));
            }
        }).start();
        System.out.println("main thread: holdLock: " + Thread.holdsLock(o));
        Thread.sleep(2000);
    }
}
