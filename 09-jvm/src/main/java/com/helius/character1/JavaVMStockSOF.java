package com.helius.character1;

/**
 * @Author Helius
 * @Create 2020-07-21-10:44 下午
 */
public class JavaVMStockSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStockSOF oom = new JavaVMStockSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:"  + oom.stackLength);
            throw e;
        }
    }
}
