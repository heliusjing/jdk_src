package com.helius.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 通过多线程实现异步调用
 */
public class Main {
    public static void main(String[] args) throws Exception{
        //创建一个固定大小为10的线程池
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        //开始时间
        long start = System.currentTimeMillis();
        // 传入Callable对象，submit任务
        Future<Integer> resultFuture1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // 调用method1 and method2
                return method1() + method2();
            }
        });

        Future<Integer> resultFuture2 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Future<Integer> resultFuture3 = executorService.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return method3();
                    }
                });
                Future<Integer> resultFuture4 = executorService.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        return method4();
                    }
                });
                return method5()+resultFuture3.get()+resultFuture4.get();
            }
        });
        int result = resultFuture1.get() + resultFuture2.get();
        System.out.println("result = "+result+", total cost "+(System.currentTimeMillis()-start)+" ms");
        //关闭线程池
          executorService.shutdown();
    }
    static int method1(){
        delay200ms();
        return 1;
    }
    static int method2(){
        delay200ms();
        return 2;
    }
    static int method3(){
        delay200ms();
        return 3;
    }
    static int method4(){
        delay200ms();
        return 4;
    }
    static int method5(){
        delay200ms();
        return 5;
    }
    static void delay200ms(){
        try{
            Thread.sleep(200);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}