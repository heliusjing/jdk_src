package com.helius.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 分治法
 * mergeSort(m->n) = merge(mergeSort(m->k),mergeSort(k+1->n));
 * @Author jcf
 * @Create 2020-02-13-19:43
 */
public class MergeSort {
    public static void mergeSort(int[] nums) {
        //创建与原数组相同长度的数组
        int[] temp = new int[nums.length];
        // 这个temp其实也可以不用每次都传，显得麻烦了
        mergeSort(nums, temp, 0, nums.length-1);
    }

    private static void mergeSort(int[] nums, int[] temp, int left, int right) {
        //安全性校验
        if(left < right) {
            //从中间将数组分成两半
            int mid = (left + right) >> 1;
            // 分别对每一组数据进行排序
            mergeSort(nums, temp, left, mid); //递归，栈会保留现场
            mergeSort(nums, temp, mid+1, right);
            //将两个数组重新合并
            merge(nums, temp, left, mid+1, right);
        }
    }

    /**
     * 这步最后结合图理解，合并是通过辅助数组，先合到辅助数组，最后则复制回原数组,m
     * 两 个待合并的数组都有序了，只需要两个指针，分别指向两个数组，然后比较下，放进辅助数组
     * 有个谁先遍历完的问题，剩下直接拷贝进辅助数组就行了
     * @param nums
     * @param temp
     * @param leftPos
     * @param rightPos
     * @param rightEnd
     */
    private static void merge(int[] nums, int[] temp,
                              int leftPos, int rightPos, int rightEnd) {

        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        //对比左右两个数组并将较小的数先放到辅助数组
        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(nums[leftPos] <= nums[rightPos]) {
                temp[tmpPos++] = nums[leftPos++];
            }else {
                temp[tmpPos++] = nums[rightPos++];
            }
        }
        //把左边数组剩下的原数放到辅助数组
        while(leftPos <= leftEnd) {
            temp[tmpPos++] = nums[leftPos++];
        }
        //把右边数组剩下的原数放到辅助数组
        while(rightPos <= rightEnd) {
            temp[tmpPos++] = nums[rightPos++];
        }
        //把辅助数组复制到原数组→这是从后往前复制,也显得有点复杂了
        for(int i = 0; i < numElements; i++,rightEnd--) {
            nums[rightEnd] = temp[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 9, 3, 5, 2, 7, 4, 0, 1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
