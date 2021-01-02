package com.helius.character2;

/**
 * @Author Helius
 * @Create 2020-08-02-3:32 下午
 */
public class SimpleArgs {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数" + (i+1) + ":" + args[i]);

        }
        //默认最大堆内存占用物理内存的1/4
        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory()/1000/1_000 + "M");
    }
}
