package com.hxy.leetcode.day6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DisplayName("丑数")
class Solution3Test {

    @ParameterizedTest
    @MethodSource
    void isUgly(int num, boolean expect) {
        Solution3 solution3 = new Solution3();
        assertThat(solution3.isUgly(num), is(equalTo(expect)));
    }

    static Stream<Arguments> isUgly() {
        return Stream.of(
                Arguments.arguments(2700, true),
                Arguments.arguments(2, true),
                Arguments.arguments(1, true),
                Arguments.arguments(0, false),
                Arguments.arguments(5, true),
                Arguments.arguments(14, false),
                Arguments.arguments(6, true)
        );
    }
}