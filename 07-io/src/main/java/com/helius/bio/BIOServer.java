package com.helius.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Helius
 * @Create 2020-06-27-6:48 下午
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 线程池机制
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true) {
            //监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            executorService.execute(() -> {
                // 可以和客户端通信
                handler(socket);
            });


        }
    }

    // 编写一个handler方法，和客户端通迅
    public static void handler(Socket socket) {
        //通过socket获取输入流
        try {
            byte[]  bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
