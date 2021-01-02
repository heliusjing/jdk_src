package com.helius.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Author Helius
 * @Create 2020-06-30-10:09 下午
 */
public class NetworkNio {
    public static void main(String[] args) {
        DatagramChannel channel;

        try {
            channel = DatagramChannel.open();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(new String("你好，我是客户端").getBytes("UTF-8"));
            byteBuffer.flip();
            channel.send(byteBuffer,new InetSocketAddress("127.0.0.1",3335));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
