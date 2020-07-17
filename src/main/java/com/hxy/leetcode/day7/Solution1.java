package com.hxy.leetcode.day7;

/**
 * 题目：缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 * <p>
 * 示例：
 * 输入: [3,0,1]
 * 输出: 2
 *
 * @author huangxy
 * @date 2020/07/17 16:27:03
 */
public class Solution1 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 输入数组
     * @return 缺失的数字
     */
    public int missingNumber(int[] nums) {
        int expectSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectSum - actualSum;
    }

}
