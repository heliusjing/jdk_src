package com.helius.book.charter01;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author chengfei.jin
 */
public class NotifyWaitTest {

    //创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    /**
     * result:
     *  threadA get resourceA lock
     *  threadA get resourceB lock
     *  threadA release resourceA lock
     *  threadB get resourceA lock
     *
     * 当线程调用调用共享对象的wait()方法时，当前线程只会释放当前共享对象的锁
     * 当前线程持有的其他共享对象的监视器锁并不会被释放
     * @throws InterruptedException
     */
    @Test
    public void test01() throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    //获取resourceB共享资源的监视器锁
                    synchronized (resourceB) {
                        System.out.println("threadA get resourceB lock");

                        //线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadA release resourceA lock");

                        resourceA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {

                //休眠一秒
                TimeUnit.SECONDS.sleep(1);

                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    //获取resourceB共享资源的监视器锁
                    synchronized (resourceB) {
                        System.out.println("threadB get resourceB lock");

                        //线程A阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadB release resourceA lock");

                        resourceA.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }


    static Object obj = new Object();

    /**
     * 线程中断
     */
    @Test
    public void test02() throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin---");
                    //阻塞当前线程
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("--end---");
                } catch (InterruptedException e) {
                    System.out.println("threadA中断抛出来的异常");
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        Thread.sleep(1000);
        System.out.println("---begin interrupt threadA");
        threadA.interrupt();
        System.out.println("---end interrupt threadA");
    }

}
