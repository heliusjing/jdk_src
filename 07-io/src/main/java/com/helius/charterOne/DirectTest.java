package com.helius.charterOne;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @Author Helius
 * @Create 2020-07-06-9:37 下午
 */
public class DirectTest {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("A");
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE);
        System.out.println("B");
        byte[] byteArray = new byte[]{1};
        System.out.println(Integer.MAX_VALUE);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            byteBuffer.put(byteArray);

        }
        System.out.println("put end");
        TimeUnit.SECONDS.sleep(1);

        Method cleaner = byteBuffer.getClass().getMethod("cleaner");
        cleaner.setAccessible(true);
        Object returnValue = cleaner.invoke(byteBuffer);
        Method clean = returnValue.getClass().getMethod("clean");

        clean.setAccessible(true);
        clean.invoke(returnValue);
        //此程序运行的效果就是一秒种之后立即回收内存
        // 也就是回收"直接缓冲区"所占用的内存


    }
}
