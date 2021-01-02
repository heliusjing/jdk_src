package com.helius.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Helius
 * @Create 2020-08-06-12:03 上午
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done,D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
