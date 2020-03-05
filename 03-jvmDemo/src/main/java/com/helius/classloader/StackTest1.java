package com.helius.classloader;

/**
 * @Author jcf
 * @Create 2020-02-10-13:24
 */
public class StackTest1 {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("i = " + i);
        int value = method1();
        System.out.println("value = " + value);
    }

    public static int method1() {
        int a = 3;
        int b = 5;
        long c = 9;
        int d = 15;
        return a+ b;
    }
}
