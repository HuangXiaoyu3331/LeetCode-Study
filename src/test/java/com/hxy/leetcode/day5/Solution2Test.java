package com.hxy.leetcode.day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("重新排列数组")
class Solution2Test {

    @ParameterizedTest
    @MethodSource
    void shuffle(int[] nums, int n, int[] expects) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.shuffle(nums, n), is(equalTo(expects)));
    }

    static Stream<Arguments> shuffle() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 5, 1, 3, 4, 7}, 3, new int[]{2, 3, 5, 4, 1, 7}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4, new int[]{1, 4, 2, 3, 3, 2, 4, 1}),
                Arguments.arguments(new int[]{1, 1, 2, 2}, 2, new int[]{1, 2, 1, 2})
        );
    }
}