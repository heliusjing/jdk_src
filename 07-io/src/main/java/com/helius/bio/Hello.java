package com.helius.bio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author Helius
 * @Create 2020-06-30-10:40 下午
 */
class Send implements Runnable {
    private PipedOutputStream out = null;

    public Send() {
        out = new PipedOutputStream();
    }

    public PipedOutputStream getOut() {
        return this.out;
    }

    @Override
    public void run() {
        String message = "hello, Helius";
        try {
            out.write(message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Recive implements Runnable {
    private PipedInputStream input = null;

    public Recive() {
        this.input = new PipedInputStream();
    }

    public PipedInputStream getInput() {
        return this.input;
    }

    @Override
    public void run() {
        byte[] b = new byte[1024];

        int len = 0;
        try {
            len = this.input.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接受的内容为" + new String(b,0,len));
    }
}

public class Hello {
    public static void main(String[] args) throws IOException {
        Send send = new Send();
        Recive recive = new Recive();
        send.getOut().connect(recive.getInput());
        //反过来连接效果一样
        new Thread(send).start();
        new Thread(recive).start();
    }
}

