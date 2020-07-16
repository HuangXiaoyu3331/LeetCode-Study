package com.hxy.leetcode.day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DisplayName("数组异或操作")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void xorOperation(int n, int start, int expect) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.xorOperation(n, start), is(equalTo(expect)));
    }

    static Stream<Arguments> xorOperation() {
        return Stream.of(
                Arguments.arguments(5, 0, 8),
                Arguments.arguments(4, 3, 8),
                Arguments.arguments(1, 7, 7),
                Arguments.arguments(10, 5, 2)
        );
    }

}