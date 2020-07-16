package com.hxy.leetcode.day2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("两数相加")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void addTwoNumbers(Solution1.ListNode l1, Solution1.ListNode l2) {
        Solution1 solution1 = new Solution1();
        solution1.addTwoNumbers(l1, l2);
    }

    static Stream<Arguments> addTwoNumbers() {
        Solution1.ListNode l1 = new Solution1.ListNode(2);
        l1.next = new Solution1.ListNode(4);
        l1.next.next = new Solution1.ListNode(3);

        Solution1.ListNode l2 = new Solution1.ListNode(5);
        l2.next = new Solution1.ListNode(6);
        l2.next.next = new Solution1.ListNode(4);
        return Stream.of(Arguments.arguments(l1, l2));
    }

}