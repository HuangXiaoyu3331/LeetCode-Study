package com.hxy.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution2Test {

    @ParameterizedTest
    @MethodSource("initParameter")
    void rec_subset(int[] arr, int s, boolean result) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.rec_subset(arr, arr.length - 1, s), is(equalTo(result)));
    }

    @ParameterizedTest
    @MethodSource("initParameter")
    void dp_subset(int[] arr, int s, boolean result) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.dp_subset(arr, s), is(equalTo(result)));
    }

    static Stream<Arguments> initParameter() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 34, 4, 12, 5, 2}, 9, true),
                Arguments.arguments(new int[]{3, 34, 4, 12, 5, 2}, 10, true),
                Arguments.arguments(new int[]{3, 34, 4, 12, 5, 2}, 11, true),
                Arguments.arguments(new int[]{3, 34, 4, 12, 5, 2}, 12, true),
                Arguments.arguments(new int[]{3, 34, 4, 12, 5, 2}, 13, false)
        );
    }
}