package com.helius.character3.reference;

/**
 * 此代码演示了两点：
 * 1.对象可以在被gc时自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统调用一次
 * @Author Helius
 * @Create 2020-07-22-11:57 下午
 */
public class FinalizeEscapeGC {
    //方法区中的静态变量，可以作为gc roots对象
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive : ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        // 对象的自我拯救，回到了gc roots引用链上
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //手动置为null,加速gc
        SAVE_HOOK = null;
        //督促jvm进行gc
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ,i am dead : (");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ,i am dead : (");
        }

    }
}

