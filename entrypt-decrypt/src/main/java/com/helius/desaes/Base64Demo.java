package com.helius.desaes;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author Helius
 * @Create 2020-05-30-4:20 下午
 */
public class Base64Demo {
    public static void main(String[] args) {
        String text = "hello world";
        String s = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(s);

        byte[] decode = Base64.getDecoder().decode(s);
        String last = new String(decode,StandardCharsets.UTF_8);
        System.out.println("last = " + last);
    }
}
