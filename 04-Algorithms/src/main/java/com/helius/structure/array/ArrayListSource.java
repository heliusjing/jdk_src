package com.helius.structure.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSource {

    public static void main(String[] args) {
        //初始化集合
        List<String> list = new ArrayList<String>(1);
        
        //向集合中添加元素
        list.add("itcast");
        
        //获取刚刚存入的元素
        String ele = list.get(0);
        
    }
}
