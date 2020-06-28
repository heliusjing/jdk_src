package com.helius.digest;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * 摘要算法
 * @Author Helius
 * @Create 2020-05-30-5:41 下午
 */
public class digestDemo {
    public static void main(String[] args) throws Exception {
        String input = "我最帅";
        String algorithm = "MD5";
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        //这里转出来是字节数组
        byte[] digest1 = digest.digest(input.getBytes());
        //
        for (byte b : digest1) {
            //把密文转成16进制
            //这里b可能是一个字节，需要在高位进行补0，要不然拼起来长度就不对了
            String s = Integer.toHexString(b & 0xff);
            System.out.print(s);
        }
        System.out.println();
        String encode = Base64.getEncoder().encodeToString(digest1);
        System.out.println("encode = " + encode);


    }
}
