package com.hxy.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1
 * 例子：s = "leetcode" 返回 0，s = "loveleetcode" 返回 2
 *
 * @author huangxy
 * @date 2022/01/09
 */
public class Solution2 {

    /**
     * 时间复杂度：O(m)
     * 空间复杂度：O(∣Σ∣), Σ < 16
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
