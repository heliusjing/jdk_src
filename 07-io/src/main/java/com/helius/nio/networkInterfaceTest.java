package com.helius.nio;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Author Helius
 * @Create 2020-07-10-12:07 上午
 */
public class networkInterfaceTest {
    public static void main(String[] args) throws SocketException {
/*        NetworkInterface eth0 = NetworkInterface.getByName("eth0");
        if (eth0 == null)
            System.out.println("hah");
        else
            System.out.println("null lala");*/

        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            System.out.println(networkInterface);
        }
    }
}
