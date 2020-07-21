package com.hxy.leetcode.day8;

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

@DisplayName("最大数")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void largestNumber(int[] nums, String expect) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.largestNumber(nums), is(equalTo(expect)));
    }

    static Stream<Arguments> largestNumber() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 30, 34, 5, 9}, "9534330"),
                Arguments.arguments(new int[]{0}, "0"),
                Arguments.arguments(new int[]{10, 2}, "210")
        );
    }
}