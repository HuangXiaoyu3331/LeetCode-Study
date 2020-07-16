package com.hxy.leetcode.day6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@DisplayName("只出现一次的数字 III")
class Solution2Test {

    @ParameterizedTest
    @MethodSource
    void singleNumberUseTwoBitmask(int[] nums, int[] expectArr1, int[] expectArr2) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.singleNumberUseTwoBitmask(nums), anyOf(equalTo(expectArr1), equalTo(expectArr2)));
    }

    static Stream<Arguments> singleNumberUseTwoBitmask() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 4, 3, 2}, new int[]{1, 5}, new int[]{5, 1}),
                Arguments.arguments(new int[]{100, 2, 3, 5, 3, 2}, new int[]{5, 100}, new int[]{100, 5})
        );
    }


}