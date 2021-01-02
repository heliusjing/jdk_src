package com.helius.character3.reference;

/**
 * @Author Helius
 * @Create 2020-08-11-10:51 下午
 */
public class LongFinalize {
    public static class LF {
        private byte[] content = new byte[512];

        @Override
        protected void finalize() throws Throwable {
            try {
                System.out.println(Thread.currentThread().getId());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            LF lf = new LF();

        }
        long e = System.currentTimeMillis();
        System.out.println(e-l);
    }
}
