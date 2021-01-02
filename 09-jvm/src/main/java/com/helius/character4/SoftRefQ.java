package com.helius.character4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 软引用配合引用队列使用，自动入队，
 * @Author Helius
 * @Create 2020-08-08-6:32 下午
 */
public class SoftRefQ {
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

    static ReferenceQueue<User> softQueue = null;

    public static class CheckRefQueue extends Thread{
        @Override
        public void run() {
            while (true) {
                if (softQueue != null) {
                    UserSoftReference obj = null;
                    try {
                        obj =(UserSoftReference) softQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (obj != null) {
                        System.out.println("user id " + obj.uid + " is delete");
                    }

                }
            }
        }
    }

    public static class UserSoftReference extends SoftReference<User> {
        int uid;

        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            this.uid = referent.id;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        User u = new User(1,"mary");
        softQueue = new ReferenceQueue<>();
        UserSoftReference userSoftReference = new UserSoftReference(u, softQueue);
        u = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userSoftReference.get());

        System.out.println("try to create byte array and GC");
        byte[] b = new byte[1024 * 925 * 7];
        System.gc();
        System.out.println(userSoftReference.get());
        Thread.sleep(1000);
    }

}
