package com.helius.character10;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Helius
 * @Create 2020-08-04-10:52 下午
 */
public class GenericTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("hello","你好");
        map.put("how are you ?" ,"吃了没");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you ?"));
    }
}
