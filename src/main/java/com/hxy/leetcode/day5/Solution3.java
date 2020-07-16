package com.hxy.leetcode.day5;

/**
 * 题目：删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 *
 * @author huangxy
 * @date 2020/07/09 10:48:59
 */
public class Solution3 {

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param node 单链表中间节点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
