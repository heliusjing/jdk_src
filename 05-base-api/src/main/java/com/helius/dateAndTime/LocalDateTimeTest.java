package com.helius.dateAndTime;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @Author Helius
 * @Create 2020-05-21-11:57 下午
 */
public class LocalDateTimeTest {

    //localDate、localTime
    @Test
    public void test01() {
        LocalDate localDate = LocalDate.of(2019, 11, 1);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int monthValue = localDate.getMonthValue();
        int dayOfMonth = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfYear = localDate.getDayOfYear();
        int i = localDate.lengthOfMonth();
        boolean leapYear = localDate.isLeapYear();
        int year2 = localDate.get(ChronoField.YEAR);
        int month2 = localDate.get(ChronoField.MONTH_OF_YEAR);
        


    }
}
