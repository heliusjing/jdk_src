package com.helius.thread;

/**
 * 线程八锁
 * @Author Helius
 * @Create 2020-06-14-11:34 下午
 */
public class SimpleUserSync {
    public static int a = 0;
    //equals to
    // 锁类对象
    /**
     * synchronize (SimpleUserSync.class){a++}
     */
    public synchronized static void addA_1() {
        a++;
    }

    //锁当前对象

}
