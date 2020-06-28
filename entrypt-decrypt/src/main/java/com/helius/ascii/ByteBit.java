package com.helius.ascii;

/**
 * @Author Helius
 * @Create 2020-05-28-11:34 下午
 */
public class ByteBit {
    public static void main(String[] args) {
//        String a = "a";
//        byte[] bytes = a.getBytes();
//        System.out.println("bytes = " + bytes);
//        for (byte aByte : bytes) {
//            int c = aByte;
//            System.out.println("c = " + c);
//            //byte 字节对应的bit是多少
//            String s = Integer.toBinaryString(c);
//            System.out.println("s = " + s);
//        }
        String a = "尚";
        byte[] bytes = a.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
// 一个中文对应的是三个个字节，
// 如果是UTF-8，一个中文对应的是一个字节
// 如果是GBK，一个中文对应的是二个字节

//如果是英文，就无所谓编码格式