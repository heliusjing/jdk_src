package com.helius.hutool.core;

import cn.hutool.core.clone.CloneSupport;

/**
 * @Author Helius
 * @Create 2020-04-18-3:25 下午
 */
public class Dog extends CloneSupport<Dog> {
    private String name = "wangwang";
    private int age  = 3;
}
