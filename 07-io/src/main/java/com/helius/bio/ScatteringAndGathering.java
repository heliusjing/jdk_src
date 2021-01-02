package com.helius.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 分散和聚集
 * scatter：从Channel中读取是指在读操作时将读取的数据写入多个buffer中，
 * @Author Helius
 * @Create 2020-07-02-11:26 下午
 */
public class ScatteringAndGathering {
    public static void main(String[] args) throws IOException {
        //使用serversockerChannel和sockerChaannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        //绑定端口到socket，并启动。

        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8;
        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long l = socketChannel.read(byteBuffers);
                byteRead +=l;//累计读取的字节数
                System.out.println("byteREad=" + byteRead);

                //使用流打印，看看当前的这个buffer
                Arrays.asList(byteBuffers).stream().map(
                        Buffer::position
                ).forEach(
                        System.out::println
                );
            }

            //将所有的bufffer进行flip
            long byteWrite = 0;

            while (byteWrite < messageLength) {
                long write = socketChannel.write(byteBuffers);

                byteWrite += write;
            }


            // 将所有的buffer进行clear

            Arrays.asList(byteBuffers).forEach(
                    buffer -> buffer.clear()
            );



        }


    }
}
