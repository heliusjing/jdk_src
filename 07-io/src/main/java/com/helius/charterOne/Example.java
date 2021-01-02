package com.helius.charterOne;


import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @Author Helius
 * @Create 2020-07-06-12:05 上午
 */
public class Example {
    @Test
    public void test1() {
        byte[] byteArray = new byte[]{1, 2, 3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println(byteBuffer.getClass().getName());
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.position());
    }


    @Test
    public void test2() {
        char[] charArray = new char[] {'a','b','c','d','e'};
        CharBuffer buffer = CharBuffer.wrap(charArray);

        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());

        buffer.limit(3  );
        System.out.println(buffer.capacity());
        System.out.println(buffer.limit());

        buffer.put(0,'o');
        buffer.put(1,'p');
        buffer.put(2,'p');
        buffer.put(3,'r');
//        buffer.put(4,'s');

    }


    @Test
    public void test3() {
        char[] charArray = new char[]{'a','b','c','d','e','f'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray,2,3);

        System.out.println(charBuffer.capacity());
        System.out.println(charBuffer.limit());
        System.out.println(charBuffer.position());
        charBuffer.position(2 );

        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }
    }

    @Test
    public void test4() {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println(byteBuffer.capacity());
        System.out.println();
        byteBuffer.position(1   );
        //在位置1处设置一个标记
        byteBuffer.mark();
        System.out.println(byteBuffer.position());
        //改变位置
        byteBuffer.position(2   );
        //位置重置，上次mark的位置
        byteBuffer.reset();
        System.out.println();
        System.out.println(byteBuffer.position());
    }


    @Test
    public void test5() {
        char[] charArray = new char[]{'a','b','c','d','e','f'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println(charBuffer.isReadOnly());


    }

    @Test
    public void test6() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println(byteBuffer.isDirect());
    }


    @Test
    public void test7() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
//        System.out.println(byteBuffer.isDirect());
        byteBuffer.put((byte) 1);
        System.out.println(byteBuffer.hasArray());
    }

    @Test
    public void test8() {
        byte[] byteArray = {1,2,3,4,5,6,7,8};

        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);

        int remaining = byteBuffer.remaining();

        for (int i = 0; i < remaining; i++) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.clear();
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.clear();

        for (; byteBuffer.hasRemaining() == true; ) {
            System.out.println(byteBuffer.get());
        }

    }


    
    







}
