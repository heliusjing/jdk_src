package com.helius.thread;

import java.util.concurrent.Callable;

/**
 * @Author Helius
 * @Create 2020-06-28-9:27 下午
 */
public class FindMaxTask implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public FindMaxTask() {
    }

    public FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer call() throws Exception {
        int max = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if(data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
}
