package com.helius;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author Helius
 * @Create 2020-06-29-10:43 下午
 */
public class transferWithNIO {
    private long test(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();
        if (!des.exists()) {
            des.createNewFile();
        }
        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024);
        while (readChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }
}
