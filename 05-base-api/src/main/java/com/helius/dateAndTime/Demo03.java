package com.helius.dateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author Helius
 * @Create 2020-04-05-11:49 下午
 */
public class Demo03 {
    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(1999, 12, 12, 12, 12, 0);
        LocalDateTime localDateTime = of.withDayOfMonth(1);
        System.out.println(localDateTime);
        //封装当前时间
//        LocalDateTime.of(2019,6,4)

        LocalDate now = LocalDate.now();
        LocalDate with = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));


    }
}
