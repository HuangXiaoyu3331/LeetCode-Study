package com.hxy.leetcode.dp;

/**
 * 题目：求数组的子集
 * 描述：给定一个正整数数组跟一个正整数，求在数组中取出任意个元素，如果取出的元素之和等于给定的正整数，则返回true，否则返回false
 * 例子：给定一个数组[3,34,4,12,5,2] 与正整数 9，因为在数组中存在子集[3,4,2]相加的值=9，故返回true。如果给定的正整数为13，则返回false
 *
 * @author huangxy
 * @date 2021/07/02 00:17:44
 */
public class Solution2 {

    // 解题思路：该问题为经典的子集问题，求一个数组中的子集是否满足给定要求
    // 设数组为 arr，长度为 i+1（即最后一个元素为i），要求的正整数为 s，subset(arr,i,s) 表示数组中，第0～i个元素，是否满足存在子集的合为s，即 subset(arr,i,s) 为我们要求的结果
    // 则存在，若 s == 0，则结果为 true
    //        若 i == 0，则结果为 arr[i] == s
    //        若 arr[i] > s，则结果为 subset(arr,i-1,s)
    //        else arr[i] = subset(arr,i-1,s) or subset(arr,i-1,s-arr[i])

    public boolean rec_subset(int[] arr, int i, int s) {
        if (s == 0)
            return true;

        if (i == 0)
            return arr[0] == s;

        if (arr[i] > s)
            return rec_subset(arr, i - 1, s);

        boolean a = rec_subset(arr, i - 1, s);
        boolean b = rec_subset(arr, i - 1, s - arr[i]);
        return a || b;
    }

    public boolean dp_subset(int[] arr, int s) {
        // 新建一个二维数组，存储之前的结果
        // 二维数组 x 轴为 arr[i]，y 轴为 s
        // subset[3][5]==true 表示在 arr[0]～arr[3] 中，有子集之和为 5
        // subset[3][5]==false 表示在 arr[0]~arr[3] 中，没有子集之和为 5
        boolean[][] subset = new boolean[arr.length][s + 1];
        // 当s==0时，结果为true
        for (int i = 0; i < arr.length; i++) {
            subset[i][0] = true;
        }

        // 当i==0时，所有均为false，除了subset[0][s-1]的值为true
        subset[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < s + 1; j++) {
                // 这里为什么是跟j比较，而不是跟s比较，因为二维数组subset[i][j]的值是：arr[0]~arr[i]存不存在子集的和为j
                if (arr[i] > j) {
                    subset[i][j] = subset[i - 1][j];
                } else {
                    boolean a = subset[i - 1][j];
                    boolean b = subset[i - 1][j - arr[i]];
                    subset[i][j] = a || b;
                }
            }
        }
        return subset[arr.length - 1][s];
    }

}
