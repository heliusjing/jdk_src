package com.helius.thread;

/**
 * @Author Helius
 * @Create 2020-04-06-3:22 下午
 */
public class ThreadLocalDemo1 {
    //用这个解决
    ThreadLocal<String> t1 = new ThreadLocal<>();


    private String content;

    private String getContent() {
        String s = t1.get();
        return s;
    }

    private void setContent(String content) {
        t1.set(content);
//        this.content = content;
    }

    public static void main(String[] args) {
        ThreadLocalDemo1 demo1 = new ThreadLocalDemo1();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo1.setContent(Thread.currentThread().getName());
                    System.out.println("-------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo1.getContent());
                }
            });
            thread.setName("线程"+i);
            thread.start();
        }

    }
}
