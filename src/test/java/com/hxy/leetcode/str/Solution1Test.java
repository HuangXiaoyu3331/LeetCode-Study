package com.hxy.leetcode.str;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author huangxy
 * @date 2022/01/09
 */
public class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void strStr(String haystack, String needle, int result) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.strStr(haystack, needle), is(equalTo(result)));
    }

    static Stream<Arguments> strStr() {
        return Stream.of(
                Arguments.arguments("hello", "ll", 2),
                Arguments.arguments("aaaaa", "baa", -1),
                Arguments.arguments("", "", 0)
        );
    }

}
