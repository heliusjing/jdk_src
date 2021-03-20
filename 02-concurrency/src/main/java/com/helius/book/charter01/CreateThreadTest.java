package com.helius.book.charter01;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chengfei.jin
 */
public class CreateThreadTest {

    /**
     * 这里主线程没有等待子线程运行结束就可能会结束了，存在没有打印的情况。
     */
    @Test
    public void test01() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    /**
     * 继承Thread类
     */
    public static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("I am  a child thread");
        }
    }

    /**
     * 实现@link{Runnable}接口
     */
    public static class RunableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("I am  a child thread");
        }
    }

    @Test
    public void test02() {
        RunableTask runableTask = new RunableTask();
        //构造了两个线程
        new Thread(runableTask).start();
        new Thread(runableTask).start();
    }

    /**
     * 实现Callable接口
     */
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "hello world!";
        }
    }

    @Test
    public void test03() {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
