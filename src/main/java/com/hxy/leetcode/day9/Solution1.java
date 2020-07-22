package com.hxy.leetcode.day9;

/**
 * 题目：除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/23 00:41:45
 */
public class Solution1 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)，返回数组不算空间复杂度里
     * <p>
     * 思路：第i个数组的值=nums数组第i个元素左边的乘积 * 右边的乘积
     *
     * @param nums 输入数组
     * @return 输出数组
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        // 计算第i个元素的左边的数组的乘积，存入answer[]数组中
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 左边所有乘积的值 * 右边所有乘积的值，即为数组除i外所有乘积的值
            answer[i] = answer[i] * R;

            // 重新计算右边所有乘积的值，并存入R中
            R *= nums[i];
        }
        return answer;
    }

}
