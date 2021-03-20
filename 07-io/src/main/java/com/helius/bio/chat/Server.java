package com.helius.bio.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * bio模式下的端口转发思想
 * @author chengfei.jin
 */
public class Server {

    //定义一个静态集合
    public static List<Socket> allSocketOnLine = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true) {
                Socket socket = ss.accept();
                //把登录的客户端socket存入到在线集合中去
                allSocketOnLine.add(socket);
                //为当前登录成功的
                new ServerReaderThread(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
