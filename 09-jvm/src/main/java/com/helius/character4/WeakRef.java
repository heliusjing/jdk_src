package com.helius.character4;

import java.lang.ref.WeakReference;

/**
 * @Author Helius
 * @Create 2020-08-08-8:04 下午
 */
public class WeakRef {
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

    public static void main(String[] args) {
        User u = new User(1,"mary");
        WeakReference<User> userWeakRef = new WeakReference<>(u);
        u = null;
        System.out.println(userWeakRef.get());
        System.gc();
        //不管当前内存空间足够与否，都会回收它的内存
        System.out.println("After GC:");
        System.out.println(userWeakRef.get());

    }
}
