package com.hxy.leetcode.day1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("两数之和")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    public void twoSum(int[] nums, int target, int[] result) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.twoSum(nums, target), is(equalTo(result)));
    }

    public static Stream<Arguments> twoSum() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 9, new int[]{3, 4}),
                Arguments.arguments(new int[]{2, 4, 6, 7, 12}, 14, new int[]{0, 4})
        );
    }


}