package com.helius.ascii;

/**
 * @Author Helius
 * @Create 2020-05-28-11:19 下午
 * @Description 恺撒加密
 */
public class KaiserDemo {
    public static void main(String[] args) {
        //定义原文
        String input = "Hello World";
        int key = 3;
        char[] chars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            int b = aChar;
            b +=3;
            char newb = (char)b;
            stringBuilder.append(newb);
        }
        System.out.println(stringBuilder);
    }
}
