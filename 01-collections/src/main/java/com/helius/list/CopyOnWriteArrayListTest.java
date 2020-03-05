package com.helius.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 测试CopyOnWriteArrayList的弱一致性
 * @Author jcf
 * @Create 2020-02-16-20:24
 */
public class CopyOnWriteArrayListTest {
    public static void main(String[] args) throws InterruptedException {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
        new Thread(() -> {
            list.remove(0);
            System.out.println(list);
        }).start();
        TimeUnit.SECONDS.sleep(1);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
