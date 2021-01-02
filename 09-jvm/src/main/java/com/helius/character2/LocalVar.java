package com.helius.character2;

/**
 * @Author Helius
 * @Create 2020-08-02-8:09 下午
 */
public class LocalVar implements Cloneable {
    public static void main(String[] args) {
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 5;
    }

    public void test() {
        {
            int c = 0;
            System.out.println(c);
        }
        int d = 5;
    }
}
