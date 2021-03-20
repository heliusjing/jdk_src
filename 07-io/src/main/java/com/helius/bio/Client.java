package com.helius.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author chengfei.jin
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        OutputStream os = socket.getOutputStream();

        PrintStream ps = new PrintStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请说:");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
}
