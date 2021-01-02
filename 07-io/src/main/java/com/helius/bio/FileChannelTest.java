package com.helius.bio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Helius
 * @Create 2020-07-02-9:38 下午
 */
public class FileChannelTest {
    public static void main(String[] args) throws IOException {
         String str = "hello，尚硅谷";
        FileOutputStream fos = new FileOutputStream("1.txt");
        FileChannel fileChannel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 往缓冲区中写数据
        byteBuffer.put(str.getBytes());
        // 反转模式：变成读模式，
        byteBuffer.flip();

        //将ByteBuffer中的数据写入到Channel中
        // 从缓冲区中取数据，到fileChannel中，即1.txt是最终目的地

        fileChannel.write(byteBuffer);

        fos.close();


    }
}
