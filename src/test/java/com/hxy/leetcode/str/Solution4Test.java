package com.hxy.leetcode.str;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class Solution4Test {

    @ParameterizedTest
    @MethodSource
    void romanToInt(String s,int result) {
        Solution4 solution4 = new Solution4();
        assertThat(solution4.romanToInt(s), is(equalTo(result)));
    }

    static Stream<Arguments> romanToInt() {
        return Stream.of(
                Arguments.arguments("I",1),
                Arguments.arguments("II",2),
                Arguments.arguments("IV",4),
                Arguments.arguments("V",5)
        );
    }

}