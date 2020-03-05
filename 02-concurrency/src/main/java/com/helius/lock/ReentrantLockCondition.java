package com.helius.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();//拿到对应锁
			condition.await();
			System.out.println("wait is end,going down");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockCondition conditions = new ReentrantLockCondition();
		Thread thread = new Thread(conditions);
		thread.start();
		Thread.sleep(2000);
		lock.lock();
		condition.signal();//只有拿到对应锁上面的监视器才可以执行
		lock.unlock();
	}
}
