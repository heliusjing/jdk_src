package com.helius.character6;

/**
 * @Author Helius
 * @Create 2020-08-03-10:55 下午
 */
public class StaticB {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName("com.helius.character6.StaticA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticB init OK");
    }
}
