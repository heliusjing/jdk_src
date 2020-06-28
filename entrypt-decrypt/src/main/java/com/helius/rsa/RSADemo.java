package com.helius.rsa;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @Author Helius
 * @Create 2020-05-30-6:09 下午
 */
public class RSADemo {
    public static void main(String[] args) throws Exception {
        //创建密钥对
        String input = "测试字符串";
        String algorithm = "RSA";
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        KeyPair keyPair = generator.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();
        byte[] privateEncoded = aPrivate.getEncoded();
        byte[] publicEncoded = aPublic.getEncoded();

/*        String encode = Base64.getEncoder().encodeToString(privateEncoded);
        byte[] decode = Base64.getDecoder().decode(publicEncoded);
        System.out.println("decode = " + decode);
        System.out.println("encode = " + encode);*/

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE,aPrivate);
        byte[] bytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        System.out.println("加密后的字符串 = " + new String(bytes,StandardCharsets.ISO_8859_1));
        //你会发现乱码了，因为你用UTF-8编码
        //毕竟是密文是字节数组,用base64对字节数组进行编码，使得可读性更好，。
    }
}
