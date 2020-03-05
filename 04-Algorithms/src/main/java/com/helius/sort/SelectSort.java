package com.helius.sort;

import java.util.Arrays;

/**
 * 它的基本思想是：首先在未排序的数列中找到最小(or最大)元素，
 * 然后将其存放到数列的起始位置；接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
 * 选择排序
 * @Author jcf
 * @Create 2020-02-12-21:25
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 3, 5, 2, 7, 4, 0, 1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr)
    {   //这里i<arr.length-1，剩下最后两个数，遍历完一趟， 就已经有序了，剩下最后一个数其实不需要比了
        for (int i = 0; i < arr.length-1; i++)
            {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {

                if (arr[j] < arr[min])
                {
                    min = j;
                }
            }
            // 此时min就是最小的索引
            if (i != min)
            {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

}
