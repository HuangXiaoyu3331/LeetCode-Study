package com.hxy.leetcode.day5;

/**
 * 题目：重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * 示例：
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-the-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/09 09:39:37
 */
public class Solution2 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param nums 原数组
     * @param n    数组长度中间数
     * @return 重排后的数组
     */
    public int[] shuffle(int[] nums, int n) {
        int i = 0, j = n, index = 0;
        int[] result = new int[nums.length];
        while (i < n) {
            result[index] = nums[i];
            index++;
            result[index] = nums[j];
            index++;
            i++;
            j++;
        }
        return result;
    }

}
