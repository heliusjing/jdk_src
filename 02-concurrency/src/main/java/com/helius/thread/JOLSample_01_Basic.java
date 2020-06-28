package com.helius.thread;

import org.openjdk.jol.info.ClassLayout;

public class JOLSample_01_Basic {
    public static void main(String[] args) throws Exception {
        System.out.println(ClassLayout.parseInstance(new JOLSample_01_Basic.A()).toPrintable());
    }

    public static class A {
        boolean f;
        int a;
    }

}
