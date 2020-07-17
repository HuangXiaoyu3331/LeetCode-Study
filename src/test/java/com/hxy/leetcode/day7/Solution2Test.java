package com.hxy.leetcode.day7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class Solution2Test {

    @ParameterizedTest
    @MethodSource
    void hIndex(int[] nums, int expect) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.hIndex(nums), is(equalTo(expect)));
    }

    static Stream<Arguments> hIndex() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 0, 6, 1, 5}, 3),
                Arguments.arguments(new int[]{10, 0, 6, 1, 5}, 3),
                Arguments.arguments(new int[]{1, 0, 6, 1, 5}, 2)
        );
    }
}