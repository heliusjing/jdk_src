package com.helius.aqs;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Helius
 * @Create 2020-06-14-11:23 下午
 */
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        String why = map.get("why");
        System.out.println("第一次:" + why);
        map.computeIfAbsent("why", key -> getValue());
        why = map.get("why");
        System.out.println("第二次:" + why);

    }

    private static String getValue() {
        return "why技术";
    }
}
