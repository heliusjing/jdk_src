package com.helius.exception;

/**
 * analyize try-catch byte class
 * @Author Helius
 * @Create 2020-06-03-12:30 上午
 */
public class AppTest {
    public static void main(String[] args) {
        try {
            int count = 0;
            throw new Exception("new Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
