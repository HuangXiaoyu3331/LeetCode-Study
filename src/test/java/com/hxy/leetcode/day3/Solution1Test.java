package com.hxy.leetcode.day3;

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

@DisplayName("无重复字符的最长字串")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void lengthOfLongestSubstring(String s, int count) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.lengthOfLongestSubstring(s),is(equalTo(count)));
    }

    static Stream<Arguments> lengthOfLongestSubstring() {
        return Stream.of(
                Arguments.arguments("abcdefg", 7),
                Arguments.arguments("ababababab", 2),
                Arguments.arguments("aaaaaa", 1),
                Arguments.arguments("abccbaabccba", 3),
                Arguments.arguments("abcdeab", 5)
        );
    }
}