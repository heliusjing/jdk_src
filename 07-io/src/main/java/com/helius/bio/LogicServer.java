package com.helius.bio;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Author Helius
 * @Create 2020-06-27-7:41 下午
 */
public class LogicServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("客户端：" + info);

            }
            //给客户端回应
            String reply = "我收到你的消息啦！！！";
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(reply.getBytes(Charset.defaultCharset()));
            //不写到finally了，直接关闭
            outputStream.close();
            br.close();
            inputStream.close();
            socket.close();
            serverSocket.close();//服务端一般不关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
