package com.helius.escapeAnalysis;

/**
 * @Author Helius
 * @Create 2020-07-19-7:24 下午
 */
public class TestEscapeAnalysis {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("const:" + (end - start) + "ms");
        //为了方便查看堆内存中对象的个数，线程sleep
//        try {
//            TimeUnit.SECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private static void alloc() {
        User user = new User();
    }

    static class User {
    }

}
