package com.hxy.leetcode.day10;

/**
 * 题目： 判定字符是否唯一
 * 描述：实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 示例1：
 * 输入: s = "leetcode"
 * 输出: false
 * <p>
 * 示例2：
 * 输入: s = "abc"
 * 输出: true
 * <p>
 * 限制：
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * @author huangxy
 * @date 2020/08/18 23:55:31
 */
public class Solution1 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean isUnique(String astr) {
        // ASCII 编码有128个字符，使用 2 个 long 类型来存储是否出现某个字符（一个long占64位）
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            // & 如果相对应位都是1，则结果为1，否则为0
            // ｜ 如果相对应位都是0，则结果为0，否则为1
            // 使用 & ｜ 运算，判断是否出现重复的字符
            if (c >= 64) {
                long bitIndex = 1L << c - 64;
                if ((high64 & bitIndex) != 0) {
                    return false;
                }
                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }
                low64 |= bitIndex;
            }
        }
        return true;
    }

}
