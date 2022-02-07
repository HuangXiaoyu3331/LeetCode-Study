package com.hxy.leetcode.str;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class Solution3Test {

    @ParameterizedTest
    @MethodSource
    void mergeTwoLists(Solution3.ListNode l1, Solution3.ListNode l2, Solution3.ListNode result) {
        Solution3 solution3 = new Solution3();
        assertThat(solution3.mergeTwoLists(l1, l2), is(equalTo(result)));
    }

    static Stream<Arguments> mergeTwoLists() {
        return Stream.of(
                Arguments.arguments(
                        Solution3.ListNode.build(1, 2, 4),
                        Solution3.ListNode.build(1, 3, 4),
                        Solution3.ListNode.build(1, 1, 2, 3, 4, 4)
                )
        );
    }

}