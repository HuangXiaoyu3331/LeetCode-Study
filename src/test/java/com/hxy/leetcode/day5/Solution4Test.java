package com.hxy.leetcode.day5;

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

@DisplayName("猜数字")
class Solution4Test {

    @ParameterizedTest
    @MethodSource
    void game(int[] guess, int[] answer, int expect) {
        Solution4 solution4 = new Solution4();
        assertThat(solution4.game(guess, answer), is(equalTo(expect)));
    }

    static Stream<Arguments> game() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 3),
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{3, 3, 1}, 0),
                Arguments.arguments(new int[]{1, 2, 1}, new int[]{1, 2, 3}, 2),
                Arguments.arguments(new int[]{1, 1, 1}, new int[]{1, 2, 3}, 1)
        );
    }

}