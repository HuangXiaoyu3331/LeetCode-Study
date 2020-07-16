package com.hxy.leetcode.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("拥有最多糖果的孩子")
class Solution3Test {

    @ParameterizedTest
    @MethodSource
    void kidsWithCandies(int[] candies, int extraCandies, List<Boolean> expects) {
        Solution3 solution3 = new Solution3();
        assertThat(solution3.kidsWithCandies(candies, extraCandies), is(equalTo(expects)));
    }

    static Stream<Arguments> kidsWithCandies() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 3, 5, 1, 3}, 3, Arrays.asList(true, true, true, false, true)),
                Arguments.arguments(new int[]{4, 2, 1, 1, 2}, 1, Arrays.asList(true, false, false, false, false)),
                Arguments.arguments(new int[]{12, 1, 12}, 10, Arrays.asList(true, false, true))
        );
    }

}