package com.helius.sort;

import java.util.Arrays;

/**
 * 快速排序(Quick Sort)使用分治法策略。
 * 它的基本思想是：选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
 * 其中一部分的所有数据都比另外一部分的所有数据都要小。
 * 然后，再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序流程：
 * (1) 从数列中挑出一个基准值。
 * (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；
 * 在这个分区退出之后，该基准就处于数列的中间位置。
 * (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 * @Author Helius
 * @Create 2020-02-29-10:43
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,9,3,5,2,7,4,0,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int l,int r){
        if (l < r) {
            int i ,j ,x;
            i = l;
            j = r;
            x = arr[i]; //基准值,一般取第一个元素即可
            while (i < j) {
                //只要i<j，说明左右两边往中间靠拢，还没有相遇，就继续遍历
                //遍历右边,为啥从右边开始，因为基准值在左边,基准值已经被保存在x中，基准值的位置是空的，将来右边遍历到交换的值，
                //直接放在基准值的位置上，所以从右边开始
                while (i < j && arr[j] > x) j--;
                //调出循环了，说明右边找到一个值比基准值小,就把他放在左边
                if (i<j) arr[i++] = arr[j];//i++,是因为已经被填充了值，下一次左边开始遍历时，直接从i+1开始遍历即可，注意这是后++
                while (i<j&& arr[i] < x) i++;
                if (i<j) arr[j--] = arr[i];//说明与上边类似，自己思考
            }
            // 跳出了循环，说明此时i=j了
            arr[i] = x; // 注意此时，i = j 的位置一定是空的，如果不是
            //举个例子
            //分两部分递归
            quickSort(arr,l,i -1);
            quickSort(arr,i+1,r);
        }
    }
}
