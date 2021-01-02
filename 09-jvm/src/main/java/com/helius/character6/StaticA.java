package com.helius.character6;

/**
 * @Author Helius
 * @Create 2020-08-03-10:53 下午
 */
public class StaticA {
    static {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        try {
            Class.forName("com.helius.character6.StaticB");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("StaticA init OK");
    }
}
