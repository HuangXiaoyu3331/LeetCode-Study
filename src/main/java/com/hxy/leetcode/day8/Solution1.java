package com.hxy.leetcode.day8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * <p>
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 *
 * @author huangxy
 * @date 2020/07/21 23:16:57
 */
public class Solution1 {

    /**
     * 时间复杂度：O(nlogn)，因为 compareTo 比较函数的时间复杂度是 O(nlogn)
     * 空间复杂度：O(n)，因为使用了数组保存 nums 的副本
     *
     * @param nums 入参
     * @return 最大数
     */
    public String largestNumber(int[] nums) {
        // 将 nums 转成字符串
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // 对 asStrs 数组进行降序排序
        Arrays.sort(asStrs, new LargerNumberComparator());

        // 提前返回
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // 拼接最大数返回
        StringBuilder largestNumer = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumer.append(numAsStr);
        }

        return largestNumer.toString();
    }

    private static class LargerNumberComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }

    }

}
