package com.hxy.leetcode.day6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DisplayName("各位相加")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void addDigits(int num, int expect) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.addDigits(num), is(equalTo(expect)));
    }

    static Stream<Arguments> addDigits() {
        return Stream.of(
                Arguments.arguments(38, 2),
                Arguments.arguments(123, 6),
                Arguments.arguments(9, 9),
                Arguments.arguments(987, 6)
        );
    }
}