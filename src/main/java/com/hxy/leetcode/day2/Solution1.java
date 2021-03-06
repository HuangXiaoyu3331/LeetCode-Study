package com.hxy.leetcode.day2;

/**
 * 题目：两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author huangxy
 * @date 2020/07/05 15:55:36
 */
public class Solution1 {

    /**
     * 假设 m、n 分别为 l1、l2 的长度
     * <p>
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(max(m,n))
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 相加后的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 判空
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode p = l1, q = l2;
        int carry = 0;
        do {
            int x = (p == null ? 0 : p.val);
            int y = (q == null ? 0 : q.val);

            int sum = x + y + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            p = p == null ? null : p.next;
            q = q == null ? null : q.next;

        } while (p != null || q != null);

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }

        return result.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
