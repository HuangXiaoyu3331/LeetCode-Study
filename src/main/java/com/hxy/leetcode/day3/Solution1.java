package com.hxy.leetcode.day3;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：无重复字符的最长字串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * <p>
 * 示例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/06 10:30:44
 */
public class Solution1 {

    /**
     * 时间复杂度：O(n) -> while 循环，最多执行 n 次
     * 空间复杂度：O(∣Σ∣) -> 其中 Σ 表示字符集（即字符串中可以出现的字符）
     *
     * @param s 字符串
     * @return 字符串中无重复字符的最长字串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // HashSet集合，用于判断字符是否重复出现
        Set<Character> occ = new HashSet<>();
        // rk -> 右指针，记录遍历过的元素位置
        int rk = -1, length = 0;
        for (int i = 0; i < s.length(); i++) {

            // 移除上一个元素
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }

            // 移动右指针，直至发现重复元素
            while (rk + 1 < s.length() && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }

            // 这里使用 rk - i + 1 计算，也可以直接使用 occ.size()
            length = Math.max(length, rk - i + 1);
        }
        return length;
    }

}
