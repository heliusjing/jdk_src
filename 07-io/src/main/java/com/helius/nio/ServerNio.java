package com.helius.nio;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Author Helius
 * @Create 2020-06-30-10:14 下午
 */
public class ServerNio {
    public static void main(String[] args) {
        DatagramChannel datagramChannel;
        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.socket().bind(new InetSocketAddress(3335));;
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            datagramChannel.receive(byteBuffer);
//            System.err.println(new String(byteBuffer.array()).trim());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
