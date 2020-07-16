package com.hxy.leetcode.day6;

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

@DisplayName("丑数 II")
class Solution4Test {

    @ParameterizedTest
    @MethodSource
    void nthUglyNumber(int n, int expect) {
        Solution4 solution4 = new Solution4();
        assertThat(solution4.nthUglyNumber(n), is(equalTo(expect)));
    }

    static Stream<Arguments> nthUglyNumber() {
        return Stream.of(
                Arguments.arguments(10, 12),
                Arguments.arguments(1, 1),
                Arguments.arguments(7, 8)
        );
    }
}