package com.helius.character1;

/**
 * @Author Helius
 * @Create 2020-07-22-1:20 上午
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;
    
    private byte[] bigSize = new byte[2 * _1MB];
    public static void testGC() {

    }

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        // 假设在这行发生gc，两对象是否被强制 回收
        System.gc();
    }
}
