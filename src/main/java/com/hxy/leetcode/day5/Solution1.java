package com.hxy.leetcode.day5;

/**
 * 题目：数组异或操作
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果
 * <p>
 * 示例：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/09 09:28:31
 */
public class Solution1 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param n     数组长度
     * @param start 数组元素增量
     * @return 数组异或操作结果
     */
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }

}
