package com.helius.sort;

import java.util.Arrays;

/**
 * 希尔排序又称为缩小增量排序
 * @Author Helius
 * @Create 2020-02-29-10:07
 * 希尔排序实质上是一种分组插入方法。它的基本思想是：对于n个待排序的数列，
 * 取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列，
 * 所有距离为gap的倍数的记录放在同一个组中；然后，对各组内的元素进行直接插入排序。
 * 这一趟排序完成之后，每一个组的元素都是有序的。
 * 然后减小gap的值，并重复执行上述的分组和排序。
 * 重复这样的操作，当gap=1时，整个数列就是有序的。
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,9,3,5,2,7,4,0,1};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void shellSort(int[] arrays) {

        //增量每次都/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {
            //自己理解：每一组都是插入排序
            /**
             * 无序区：0---step-1
             * 有序区：step---arrays.length-1
             * 每组都是插入排序，1,step+1,2step+1  ... <arrays.length
             * 移位法插入，
             * int temp = arrays[j]
             * while(arrays[j-step] > temp && j -step>=0){
             *      此时，这是一种冒泡。。
             *      只是对每一组的元素而已 ，前面已经有序了。
             *      把大的放后面
             *      再递减j = j -step
             *      再往前找一个元素，
             * }
             */

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arrays.length; i++) {

                int j = i;
                int temp = arrays[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }

    }
}
