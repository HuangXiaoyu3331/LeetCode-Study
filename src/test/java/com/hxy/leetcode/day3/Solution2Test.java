package com.hxy.leetcode.day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class Solution2Test {

    @ParameterizedTest
    @MethodSource("initParameters")
    void findMedianSortedArrays1(int[] nums1, int[] nums2, double median) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.findMedianSortedArrays1(nums1, nums2), is(equalTo(median)));
    }

    @ParameterizedTest
    @MethodSource("initParameters")
    void findMedianSortedArrays2(int[] nums1, int[] nums2, double median) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.findMedianSortedArrays2(nums1, nums2), is(equalTo(median)));
    }

    @ParameterizedTest
    @MethodSource("initParameters")
    void findMedianSortedArrays3(int[] nums1, int[] nums2, double median) {
        Solution2 solution2 = new Solution2();
        assertThat(solution2.findMedianSortedArrays3(nums1, nums2), is(equalTo(median)));
    }

    static Stream<Arguments> initParameters() {
        return Stream.of(
                Arguments.arguments(new int[]{1}, new int[]{2, 3, 4, 5}, 3.0),
                Arguments.arguments(new int[]{1}, new int[]{2, 3, 4, 5, 6}, 3.5),
                Arguments.arguments(new int[]{1, 7, 8, 9}, new int[]{2, 3, 4, 5, 6}, 5.0),
                Arguments.arguments(new int[]{1, 2}, new int[]{2, 3}, 2.0),
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{2, 3}, 2.0),
                Arguments.arguments(new int[]{9}, new int[]{2, 3}, 3.0)
        );
    }
}