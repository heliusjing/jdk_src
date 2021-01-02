package com.helius.character10;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Helius
 * @Create 2020-08-04-11:11 下午
 */
public class AutoBoxTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }
}
