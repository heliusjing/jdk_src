package com.helius.sort;

import java.util.Arrays;

/**
 *直接插入排序(Straight Insertion Sort)的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表。
 * 开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，
 * 将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
 * @Author jcf
 * @Create 2020-02-12-21:00
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,9,3,5,2,7,4,0,1};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        //从1开始，即默认数组第一个元素为有序区，剩下的元素为无序区
        for (int i = 1; i < arr.length; i++) {
            //每次都取无序区的第一个元素，即j=i开始，往前面，（前面就是有序区了）,通过依次冒泡找到位置。
            //这里精华的地方，刚好取的无序区第一个元素，那个位置空出来，可以用来交换，
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    //交换位置
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
