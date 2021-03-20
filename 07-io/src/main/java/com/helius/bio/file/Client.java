package com.helius.bio.file;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 实现客户端上传任意类型的文件数据给服务端保存起来
 * @author chengfei.jin
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            //把字节输出流包装一个数据输出流
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(".png");
            InputStream is = new FileInputStream("/Users/helius/Downloads/【信公小安】-创业板注册制知识测试-20210108.png");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                dos.write(buffer,0,len);
            }
            dos.flush();
            socket.shutdownOutput();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close
        }
    }
}
