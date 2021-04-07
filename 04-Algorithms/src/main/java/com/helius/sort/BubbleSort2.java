package com.helius.sort;

import java.util.Arrays;

/**
 * 冒泡排序，未优化前的
 * @author chengfei.jin
 */
public class BubbleSort2 {

    public static void sort(Comparable[] a) {
        //第一个循环，就是所有的需要冒泡的元素
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //比较索引j和j+1处的值
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

        /**
         * 主方法：测试
         * @param args
         */
        public static void main(String[] args) {
            Integer a [] = new Integer[]{18,62,68,82,65,9};
            //排序前，先把内容打印出来
            System.out.println(Arrays.toString(a));
            BubbleSort2.sort(a);
            System.out.println(Arrays.toString(a));
        }
}
