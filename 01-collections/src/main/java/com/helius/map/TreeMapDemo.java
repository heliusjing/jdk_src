package com.helius.map;

import java.util.TreeMap;

/**
 * TreeMap学习
 * @Author Helius
 * @Create 2020-06-09-9:23 下午
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(123,"abc");
        map.put(789,"def");
        map.put(456,"qwe");
        map.put(123,"zxc");
        System.out.println(map);
    }
}
