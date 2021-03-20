package com.helius.bio.fackAsyncIo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chengfei.jin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            HandlerSocketServerPool pool = new HandlerSocketServerPool(6, 10);
            while (true) {
                Socket socket = ss.accept();
                //初始化一个
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        } catch (Exception e) {

        }
    }
}
