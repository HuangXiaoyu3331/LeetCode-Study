package com.hxy.leetcode.day10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void isUnique(String astr, boolean expect) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.isUnique(astr), is(equalTo(expect)));
    }

    static Stream<Arguments> isUnique() {
        return Stream.of(
                Arguments.arguments("abc", true),
                Arguments.arguments("aba", false),
                Arguments.arguments("abcdefghijklmn", true),
                Arguments.arguments("asdfjkl;", true),
                Arguments.arguments(";;mabcd", false)
        );
    }
}