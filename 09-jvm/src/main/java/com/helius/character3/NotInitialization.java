package com.helius.character3;

/**
 * @Author Helius
 * @Create 2020-07-29-1:05 上午
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(Subclass.value);
    }
}

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}

class Subclass extends SuperClass {
    static {
        System.out.println("SubClass init !");
    }
}

