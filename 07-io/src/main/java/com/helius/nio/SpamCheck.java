package com.helius.nio;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Helius
 * @Create 2020-07-10-12:19 上午
 */
public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) {
        for (String arg : args) {

        }
    }

    private static boolean isSpammer(String arg) {
        try {
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            String query = BLACKHOLE;
            for (byte octet : quad) {

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return false;
    }

}
