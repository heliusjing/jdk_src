package com.helius.hutool.core;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;

/**
 * 猫猫类，调用实现Cloneable方式
 * @Author Helius
 * @Create 2020-04-18-3:17 下午
 */
public class Cat implements Cloneable<Cat> {

    private String name = "miaomiao";
    private int age = 2;


    @Override
    public Cat clone() {
        try {
            return (Cat) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }


}
