package com.helius.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Helius
 * @Create 2020-06-28-10:07 下午
 */
public class ReillyByName {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
//            address = InetAddress.getByName("www.oreilly.com");
            InetAddress address1 = InetAddress.getByName("223.119.217.156");
            System.out.println("address1 = " + address1.getHostName());
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
