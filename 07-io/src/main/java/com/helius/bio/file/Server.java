package com.helius.bio.file;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端开发，可以实现接收客户端的任意类型文件，并保存到服务端磁盘
 *
 * @author chengfei.jin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true) {
                Socket socket = ss.accept();
            //4. 从数据输入流
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
