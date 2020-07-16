package com.hxy.leetcode.day4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/07 10:21:43
 */
public class Solution1 {

    /**
     * 假设n为root的节点数量
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     *
     * @param root 树的跟节点
     * @param sum 目标值
     * @return true:径上所有节点值相加等于目标和，false:未找到
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // 广度优先队列
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        // 值对比队列
        Queue<Integer> compareValueQueue = new LinkedList<>();

        // 根节点入队
        bfsQueue.offer(root);
        compareValueQueue.offer(root.val);

        while (!bfsQueue.isEmpty()) {
            TreeNode node = bfsQueue.poll();
            Integer temp = compareValueQueue.poll();

            if (node.left == null && node.right == null) {
                assert temp != null;
                if (temp == sum) {
                    return true;
                }
                continue;
            }

            if (node.left != null) {
                bfsQueue.offer(node.left);
                compareValueQueue.offer(node.left.val + temp);
            }

            if (node.right != null) {
                bfsQueue.offer(node.right);
                compareValueQueue.offer(node.right.val + temp);
            }

        }

        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
