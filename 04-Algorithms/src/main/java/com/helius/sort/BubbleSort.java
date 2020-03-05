package com.helius.sort;

import java.util.Arrays;

/**
 * 冒泡排序的时间复杂度是O(N2)。
 * 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？N-1次！因此，冒泡排序的时间复杂度是O(N2)。
 * 冒泡排序是稳定的算法，它满足稳定算法的定义。
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 * 冒泡排序：可以优化
 * @Author jcf
 * @Create 2020-02-11-21:13
 */
public class BubbleSort {
    /**
     * 主方法：测试
     * @param args
     */
    public static void main(String[] args) {
        int a [] = new int[]{18,62,68,82,65,9};
        //排序前，先把内容打印出来
        System.out.println(Arrays.toString(a));
        int[] array = bubbleSort(a);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {

        for (int j = arr.length - 1; j>0; j--) {

            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 交换其位置，
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }

}
