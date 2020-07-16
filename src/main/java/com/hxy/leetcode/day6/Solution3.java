package com.hxy.leetcode.day6;

/**
 * 题目：丑数
 * 编写一个程序判断给定的数是否为丑数。
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例：
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 * @author huangxy
 * @date 2020/07/10 18:49:36
 */
public class Solution3 {

    /**
     * 简单的递归算法
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param num 需要判断的整数
     * @return 是否为丑数
     */
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 1) {
            return false;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        }
        if (num % 3 == 0) {
            return isUgly(num / 3);
        }
        if (num % 5 == 0) {
            return isUgly(num / 5);
        }
        return false;
    }

}
