package com.helius.dateAndTime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @Author Helius
 * @Create 2020-04-06-1:07 下午
 */
public class CalendarTojava8 {
    public static void main(String[] args) {
        // 1.初始化Calendar对象
        Calendar cal = Calendar.getInstance();
        TimeZone timeZone = cal.getTimeZone();
        ZoneId zoneId = timeZone.toZoneId();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(cal.toInstant(), zoneId);


    }
}
