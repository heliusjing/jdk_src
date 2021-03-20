package com.helius.bio.fackAsyncIo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chengfei.jin
 */
public class HandlerSocketServerPool {
    private ExecutorService executorService;

    public HandlerSocketServerPool(int maxThreadNum, int queueSize) {
        executorService = new ThreadPoolExecutor(3,maxThreadNum,120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    /**
     *  ti
     */
    public void execute(Runnable target) {
        executorService.execute(target);
    }
}
