package com.helius.desaes;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author Helius
 * @Create 2020-05-28-11:43 下午
 * 对称加密DES
 * base64不是加密算法、是可读性算法，不是用来保护数据
 */
public class DesAesDemo {
    public static void main(String[] args) throws Exception {
        String input = "硅谷";
        //必须是八个字节
        String key = "12345678";
        String transformation = "DES";
        String algorithm ="DES";
        Cipher cipher = Cipher.getInstance(transformation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
        byte[] bytes = cipher.doFinal(input.getBytes());
        //加密出来的东西是字节数组，记住了！！！！
        // 我们当然需要把他转成字符串来显示
        //java中的byte类型是-128到127大小。是一种基本类型
        //我们可以利用base64,它只是一种编码方式，将字节编码后再进行显示
        System.out.println(new String(bytes));
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
        //转码
        String encode = Base64.encode(bytes);
        System.out.println("encode = " + encode);
    }


    //解密
    private static String decryptDES(String encryptDES,String key,String transFormation,String algorithm) throws Exception{
        Cipher cipher = Cipher.getInstance(transFormation);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
        byte[] bytes = cipher.doFinal(Base64.decode(encryptDES));

        return new String(bytes);
    }
}
