package com.helius.character4;

import java.lang.ref.SoftReference;

/**
 * @Author Helius
 * @Create 2020-08-08-5:29 下午
 */
public class SoftRef {
    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "[id = " + id + ", name = " + name + "]";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        User u  = new User(1,"mary");
        SoftReference<User> userSoftRef = new SoftReference<>(u);
        u = null;
        System.out.println(userSoftRef.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());
        byte[] a = new byte[1024*1024*2];
        byte[] b = new byte[1024*1024*2];
        byte[] c = new byte[1024*1024*2];
        byte[] d = new byte[1024*1024*1];
        byte[] e = new byte[1024*925*1];

        System.gc();
        Thread.sleep(1000);
        System.out.println(userSoftRef.get());
    }
}
