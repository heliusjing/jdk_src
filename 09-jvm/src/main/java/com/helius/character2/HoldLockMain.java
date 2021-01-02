package com.helius.character2;

import java.util.Random;

/**
 * @Author Helius
 * @Create 2020-08-16-3:55 下午
 */
public class HoldLockMain {
    public static Object[] lock = new Object[10];
    public static Random r = new Random();
    static {
        for (int i = 0; i < lock.length; i++) {
            lock[i] = new Object();

        }
    }

    public static class HoldLockTask implements Runnable {
        private int i;

        public HoldLockTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (lock[i]) {
                        if (i % 2 == 0) {
                            lock[i].wait(r.nextInt(10));
                        } else
                            lock[i].notifyAll();
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < lock.length * 2; i++) { //每两个线程使用同一锁对象
            new Thread(new HoldLockTask(i/2)).start();
        }
    }


}
