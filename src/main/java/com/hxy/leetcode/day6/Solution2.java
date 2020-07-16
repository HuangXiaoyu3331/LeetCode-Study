package com.hxy.leetcode.day6;

/**
 * 题目：只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例：
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * <p>
 * 注意：
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * @author huangxy
 * @date 2020/07/10 16:20:59
 */
public class Solution2 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * <p>
     * 提示：
     * 异或运算两个特性
     * 1: 0^n=0
     * 2: a^b^b=a
     * & 运算:
     * x & (-x) 是保留位中最右边1，将其余的1设置位0的方法
     *
     * @param nums
     * @return
     */
    public int[] singleNumberUseTwoBitmask(int[] nums) {
        // 将两个唯一数用x、y表示
        // 对数组所有元素进行异或操作，得到的结果为x^y
        int bitmask = 0;
        for (int n : nums) {
            bitmask ^= n;
        }

        // 保留bitmask最后一位1，将其余的位设置为0
        // 此时，该1肯定是x/y的
        int temp = bitmask & (-bitmask);

        int x = 0;
        // 遍历数组，找出x
        for (int n : nums) {
            // 将 y 从循环中剔除，有可能也会剔除掉别的元素，但这没关系
            if ((n & temp) != 0) {
                x = x ^ n;
            }
        }
        return new int[]{x, bitmask ^ x};
    }

}
