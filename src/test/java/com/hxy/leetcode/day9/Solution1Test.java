package com.hxy.leetcode.day9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DisplayName("除自身以外数组的乘积")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void productExceptSelf(int[] nums, int[] expects) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.productExceptSelf(nums), is(equalTo(expects)));
    }

    static Stream<Arguments> productExceptSelf() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.arguments(new int[]{0, 1, 2}, new int[]{2, 0, 0}),
                Arguments.arguments(new int[]{1, 3, 4}, new int[]{12, 4, 3})
        );
    }
}