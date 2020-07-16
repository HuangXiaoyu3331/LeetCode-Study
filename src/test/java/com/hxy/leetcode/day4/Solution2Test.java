package com.hxy.leetcode.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DisplayName("一维数组的动态和")
class Solution2Test {

    @ParameterizedTest
    @MethodSource
    void runningSum(int[] nums, int[] runningSum) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.runningSum(nums), is(equalTo(runningSum)));
    }

    static Stream<Arguments> runningSum() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{1, 3, 6, 10}),
                Arguments.arguments(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5}),
                Arguments.arguments(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17}),
                Arguments.arguments(new int[]{1}, new int[]{1})
        );
    }
}