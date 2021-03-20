package com.helius.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chengfei.jin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.println("服务端接受到：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
