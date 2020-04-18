package com.helius.dateAndTime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Helius
 * @Create 2020-04-05-8:43 下午
 */
public class Demo01 {

    public static void main(String[] args) {
        Date date = new Date();
        long s1 = date.getTime();
        Calendar c = Calendar.getInstance();
        c.set(1995, 11, 16);
        Date d2 = c.getTime();
        long s2 = d2.getTime();
        Long intervalDay = (s2 - s1) / 1000 / 60 / 60 / 24;
        System.out.println("1995年12月16日距离现在已经过了" + intervalDay + "天.");
        //使用新版本Java8的api来完成题目的要求
        long day = ChronoUnit.DAYS.between(LocalDate.of(1995, 12, 16), LocalDate.now());
        System.out.println();
        System.out.println("1995年12月16日距离现在已经过了" + day + "天.");

    }

}
