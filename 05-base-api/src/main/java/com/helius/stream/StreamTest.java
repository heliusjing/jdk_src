package com.helius.stream;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @Author Helius
 * @Create 2020-08-19-12:13 上午
 */
public class StreamTest {
    public static void main(String[] args) {
//        List<Integer> nums = Arrays.asList(1,2,3,6,7,4);
//        Optional<Integer> reduce = nums.stream().reduce(Integer::sum);
//        nums.stream().reduce(0, Integer::sum);
//        Stream<String> stream = Stream.of("hello", "world");
//        Stream<Object> empty = Stream.empty();
//        int[] numbers = {2,3,4,6,7,9};
//        int sum = Arrays.stream(numbers).sum();
        LocalTime nowTime = LocalTime.of(19, 34, 32);           //19:34:32
        int hour = nowTime.get(ChronoField.HOUR_OF_DAY);        //19
        int minute = nowTime.get(ChronoField.MINUTE_OF_HOUR);   //34
        int second = nowTime.get(ChronoField.SECOND_OF_MINUTE); //32

    }
}
