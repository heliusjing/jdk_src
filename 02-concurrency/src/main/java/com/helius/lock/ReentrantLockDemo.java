package com.helius.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 代码不严谨:Lock使用不当
 * 可证明：可重入锁
 *
 */
public class ReentrantLockDemo implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static int k = 0;
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			lock.lock();
				k++;
		}
		for (int i = 0; i < 1000; i++) {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockDemo demo = new ReentrantLockDemo();
		Thread t1 = new Thread(demo);
		Thread t2 = new Thread(demo);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(k);
	}

}
