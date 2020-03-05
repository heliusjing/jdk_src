package com.helius;

/**
 * 判断一个数是奇数:奇数和偶数转二进制的区别是最后一位是0还是1
 * @Author Helius
 * @Create 2020-02-29-18:16
 */
public class IsOdd {
    public boolean isOdd(int i){
//        return i%2 != 0;
        return (i & 1) == 1;
    }
}
