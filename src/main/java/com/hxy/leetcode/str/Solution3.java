package com.hxy.leetcode.str;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @author huangxy
 * @date 2022/01/17
 */
public class Solution3 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode build(Integer... list) {

            ListNode listNode = new ListNode(list[0]);
            ListNode temp = listNode;
            for (int i = 1; i < list.length; i++) {
                temp.next = new ListNode(list[i]);
                temp = temp.next;
            }
            return listNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode1 = (ListNode) o;
            ListNode listNode2 = this;

            while (listNode1.next != null) {
                if (listNode1.val != listNode2.val) {
                    return false;
                }
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

}
