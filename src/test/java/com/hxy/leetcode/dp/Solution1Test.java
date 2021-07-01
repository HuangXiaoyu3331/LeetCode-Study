package com.hxy.leetcode.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution1Test {


    @ParameterizedTest
    @MethodSource("initParameter")
    void rpc_opt(int[] arr, int maxResult) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.rec_opt(arr, arr.length - 1), is(equalTo(maxResult)));
    }

    @ParameterizedTest
    @MethodSource("initParameter")
    void dp_opt(int[] arr, int maxResult) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.dp_opt(arr), is(equalTo(maxResult)));
    }

    static Stream<Arguments> initParameter() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 4, 1, 7, 8, 3}, 15),
                Arguments.arguments(new int[]{1}, 1),
                Arguments.arguments(new int[]{1, 2}, 2),
                Arguments.arguments(new int[]{4, 1, 1, 9, 1}, 13)
        );
    }
}