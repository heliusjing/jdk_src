package com.helius.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用linkedhashmap实现一个缓存
 * @Author jcf
 * @Create 2020-02-07-19:35
 */
public class LRUCache {
    private LinkedHashMap<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() >capacity;
            }
        };
    }

    public int get(int key){
        Integer val = cache.get(key);
        return val == null ? -1 : val;
    }

    public void put(int key, int value){
        cache.put(key, value);
    }

}
