package com.hxy.leetcode.dp;

/**
 * 题目：取最大数
 * 描述：给定一个正整数数组，从数组中取不相邻的若干个数，使得取出的数相加，数值最大。输出其值
 * 例子：如给定数组[1,2,4,1,7,8,3]，从中取不相邻的数[1,4,7,3],1+4+7+3的值最大，为15，程序输出15
 *
 * @author huangxy
 * @date 2021/07/01 21:56:32
 */
public class Solution1 {

    // 解题思路，对于数组中的最后一个元素，有两种情况，取出该元素/不取出该元素
    // 如果取出该元素，那么第 i-1 个元素必然不可选，所以这时候的最大值 opt(i) = opt(i-2) + arr[i]
    // 如果不取出该元素，那么这时的最大值 opt(i) = opt(i-1)
    // 当数组长度为 1 时，必有 opt(1) = arr[0]
    // 当数组长度为 2 时，必有 opt(2) = max(arr[0],arr[1])
    // 得出以上公式后，就能利用递归/动态规划解决该问题

    /**
     * 递归方式求解
     */
    public int rec_opt(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        }
        if (i == 1) {
            return Math.max(arr[0], arr[1]);
        }
        int a = rec_opt(arr, i - 2) + arr[i];
        int b = rec_opt(arr, i - 1);
        return Math.max(a, b);
    }

    /**
     * 动态规划求解
     */
    public int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        // 防止数组越界
        if (arr.length < 2) {
            return opt[0];
        }
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int a = opt[i - 2] + arr[i];
            int b = opt[i - 1];
            opt[i] = Math.max(a, b);
        }
        return opt[arr.length - 1];
    }

}
