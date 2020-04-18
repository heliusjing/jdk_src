package com.helius.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Helius
 * @Create 2020-03-23-11:52 下午
 */
public class TestIterator {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(5);
        list.add(10);
        list.add(6);
        list.add(8);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Object next1 = iterator.next();
            System.out.println(next == next1);

        }
    }
}
