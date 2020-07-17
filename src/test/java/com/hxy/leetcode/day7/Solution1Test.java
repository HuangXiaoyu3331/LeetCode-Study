package com.hxy.leetcode.day7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void missingNumber(int[] nums, int missingNum) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.missingNumber(nums), is(equalTo(missingNum)));
    }

    static Stream<Arguments> missingNumber() {
        return Stream.of(
                Arguments.arguments(new int[]{0, 1, 3}, 2),
                Arguments.arguments(new int[]{8, 3, 0, 4, 5, 2, 6, 1}, 7)
        );
    }
}