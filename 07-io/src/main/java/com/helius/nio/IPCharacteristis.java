package com.helius.nio;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author Helius
 * @Create 2020-07-09-11:08 下午
 */
public class IPCharacteristis {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(args[0]);
        if (address.isAnyLocalAddress()) {
            System.out.println(address + "is a wildcard address");
        }
    }
}
