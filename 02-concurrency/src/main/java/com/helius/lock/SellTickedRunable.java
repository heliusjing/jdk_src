package com.helius.lock;

/**
 * @Author chengfei.jin
 */
public class SellTickedRunable implements Runnable {
    static int ticket = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 550; i++) {
            sell();
        }
    }

    private synchronized void sell() {
        System.out.println(Thread.currentThread().getName() + "开始卖票");
        try {
            //m=模拟卖票
            if (ticket <= 0) {
                System.out.println(Thread.currentThread().getName() + "卖完了");
            } else {
                Thread.sleep(5);
                ticket--;
                System.out.println(Thread.currentThread().getName() + "出票成功，现在还有" + ticket + "张票");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束卖票");
    }

    public static void main(String[] args) throws InterruptedException {
        SellTickedRunable sellTickedRunable = new SellTickedRunable();
        Thread thread1 = new Thread(sellTickedRunable, "A窗口");
        Thread thread2 = new Thread(sellTickedRunable, "B窗口");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("运行结束，剩下" + sellTickedRunable.ticket);
    }
}
