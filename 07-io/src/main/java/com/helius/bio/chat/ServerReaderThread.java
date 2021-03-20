package com.helius.bio.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author chengfei.jin
 */
public class ServerReaderThread extends Thread {

    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;
            while ((msg = br.readLine()) != null) {
            sendMsgToAllClient(msg);
            }
        } catch (IOException e) {
            System.out.println("当前有人下线");
            e.printStackTrace();
        }
    }

    private void sendMsgToAllClient(String msg) throws IOException {
        for (Socket sk : Server.allSocketOnLine) {
            PrintStream ps = new PrintStream(sk.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }

}
