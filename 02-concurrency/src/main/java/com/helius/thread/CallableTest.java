package com.helius.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Helius
 * @Create 2020-08-06-12:08 上午
 */
public class CallableTest {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0 ;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
