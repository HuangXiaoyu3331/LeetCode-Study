package com.hxy.leetcode.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：拥有最多糖果的孩子
 *
 * @author huangxy
 * @date 2020/07/07 16:01:51
 */
public class Solution3 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param candies      小孩拥有的糖果数组
     * @param extraCandies 额外糖果数
     * @return 分配完糖果，小孩糖果总数是否为最多的数组
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = 0;
        // 得到队列的最大值
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // 判断数组各数是否>=最大值
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add((candy + extraCandies) >= maxCandies);
        }

        return result;
    }

}
