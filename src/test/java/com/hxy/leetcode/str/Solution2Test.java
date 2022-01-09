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
public class Solution2Test {

    @ParameterizedTest
    @MethodSource
    void strStr(String s, int result) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.firstUniqChar(s), is(equalTo(result)));
    }

    static Stream<Arguments> strStr() {
        return Stream.of(
                Arguments.arguments("leetcode", 0),
                Arguments.arguments("loveleetcode", 2)
        );
    }

}
