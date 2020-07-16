package com.hxy.leetcode.day6;

/**
 * 题目：丑数 II
 * 编写一个程序，找出第 n 个丑数。丑数就是质因数只包含 2, 3, 5 的正整数
 * <p>
 * 示例：输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * <p>
 * 说明：
 * 1. 1 是丑数。
 * 2. n 不超过1690。
 *
 * @author huangxy
 * @date 2020/07/10 19:26:11
 */
public class Solution4 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n 要查询的丑数的位置
     * @return 第n个丑数
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[1690];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);

            if (dp[i] == dp[i2] * 2) i2++;
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
        }
        return dp[n - 1];
    }

}
