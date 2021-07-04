package com.hxy.leetcode.day3;

/**
 * 题目：寻找两个正序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例1：
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * <p>
 * 示例2：
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/06 11:29:54
 */
public class Solution2 {

    /**
     * 归并数组解法，将两个数组合并为一个数组，然后求其中位数
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     * 其中 m,n 为 nums1,nums2 的数组长度
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] nums = new int[length1 + length2];

        if (length1 == 0 && length2 == 0) {
            return 0.0;
        }

        if (length1 == 0) {
            if (length2 % 2 == 0) {
                return (nums2[length2 / 2 - 1] + nums2[length2 / 2]) / 2.0;
            } else {
                return nums2[length2 / 2];
            }
        }

        if (length2 == 0) {
            if (length1 % 2 == 0) {
                return (nums1[length1 / 2 - 1] + nums1[length1 / 2]) / 2.0;
            } else {
                return nums1[length1 / 2];
            }
        }

        int count = 0;
        int i = 0;
        int j = 0;

        while (count != (length1 + length2)) {
            if (i == length1) {
                while (j != length2) {
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if (j == length2) {
                while (i != length1) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }

        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return nums[nums.length / 2];
        }
    }

    /**
     * 双指针解法
     * 思路：求连个有序数组的中位数，其实并不需要合并数组，只要找到中位数就可以了
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * 其中 m,n 为 nums1,nums2 的数组长度
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        int numPrevValue = -1; //上一个值（当totalLength为偶数的时候，需要使用该值）
        int numCurrentValue = -1; //当前值（当totalLength为奇数的时候，该值就为中位数的值）
        int nums1Index = 0; //当前遍历的nums1数组的下标
        int nums2Index = 0; //当前遍历的nums2数组的下标
        for (int i = 0; i <= totalLength / 2; i++) {
            numPrevValue = numCurrentValue;

            // 当nums1数组还没到最后，并且nums1[nums1index]<nums2[nums2Index]的时候，就需要移动nums1Index指针，
            // 为保证nums2数组不越界，还需要判断nums2Index>=length2
            if (nums1Index < length1 && (nums2Index >= length2 || nums1[nums1Index] < nums2[nums2Index])) {
                numCurrentValue = nums1[nums1Index];
                nums1Index++;
            } else {
                numCurrentValue = nums2[nums2Index];
                nums2Index++;
            }
        }

        if (totalLength % 2 == 0) {
            return (numPrevValue + numCurrentValue) / 2.0;
        } else {
            return numCurrentValue;
        }
    }

    /**
     * 二分法解法
     * 时间复杂度：O(log(m+n))
     * 空间复杂度：O(1)
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) { // 两数组和为奇数
            return getKthElement(nums1, nums2, totalLength / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, totalLength / 2 + 1) + getKthElement(nums1, nums2, totalLength / 2)) / 2.0;
        }
    }

    /**
     * 查找第k个小的元素
     */
    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 < pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
