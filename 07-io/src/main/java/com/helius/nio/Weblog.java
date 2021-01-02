package com.helius.nio;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 日志行ip地址替换
 * @Author Helius
 * @Create 2020-07-10-12:25 上午
 */
public class Weblog {
    public static void main(String[] args) {
        try(
                FileInputStream fin = new FileInputStream(args[0]);
                Reader in = new InputStreamReader(fin);
                BufferedReader bin = new BufferedReader(in)
        ) {
            for (String entry = bin.readLine(); entry != null;
                 entry = bin.readLine()
            ) {
                //分解ip地址
                int index = entry.indexOf(" ");
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                //向DNS请求主极名并显示
                try {
                    InetAddress address = InetAddress.getByName(ip);

                    System.out.println(address.getHostName() + theRest);

                } catch (UnknownHostException ex) {
                    System.err.println(entry);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
