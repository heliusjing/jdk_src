package com.helius.ascii;

/**
 * @Author Helius
 * @Create 2020-05-28-11:15 下午
 */
public class AsciiDemo {
    public static void main(String[] args) {
//        char a = 'A';
//        int b = a;
        // 定义字符串
        String c = "AaZ";
        //需要拆开字符串
        char[] chars = c.toCharArray();
        for (char aChar : chars) {
            int asciicode = aChar;
            System.out.println("asciicode = " + asciicode);
        }
//        System.out.println(" b = " + b);
//        System.out.println("c = " + c);
    }
}
