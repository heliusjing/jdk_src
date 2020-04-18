package com.helius.dateAndTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Helius
 * @Create 2020-04-05-8:48 下午
 */
public class SimpleDateFormatUnsafeDemo {
    final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        //循环10次，创建10个线程对象去启动
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    @SuppressWarnings("AlibabaAvoidManuallyCreateThread") Date date = SIMPLE_DATE_FORMAT.parse("2018-12-12 12:12:12");
                    System.out.println(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
