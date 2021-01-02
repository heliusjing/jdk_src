package com.helius.character3.reference;

/**
 * @Author Helius
 * @Create 2020-07-22-10:36 下午
 */
public class Soft {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
/*        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get());
        System.gc();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(softReference.get());*/

    }
}
