package com.hxy.leetcode.day4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DisplayName("路径总和")
class Solution1Test {

    @ParameterizedTest
    @MethodSource
    void hasPathSum(Solution1.TreeNode root, int sum, boolean result) {
        Solution1 solution1 = new Solution1();
        assertThat(solution1.hasPathSum(root, sum), is(equalTo(result)));
    }

    static Stream<Arguments> hasPathSum() {
        Solution1.TreeNode root = arr2TreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        return Stream.of(
                Arguments.arguments(root, 22, true),
                Arguments.arguments(root, 100, false),
                Arguments.arguments(null, 0, false)
        );
    }

    private static Solution1.TreeNode arr2TreeNode(Integer[] arr) {
        return createTreeNode(arr, 1);
    }

    private static Solution1.TreeNode createTreeNode(Integer[] arr, int index) {
        if (index <= arr.length) {
            Integer value = arr[index - 1];
            if (value != null) {
                Solution1.TreeNode parent = new Solution1.TreeNode(value);
                parent.left = createTreeNode(arr, index * 2);
                parent.right = createTreeNode(arr, index * 2 + 1);
                return parent;
            }
        }
        return null;
    }

}