package com.yuli.leetcode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 1、可以使用hash来保存位置和数据
 * 2、可以使用快慢指针，让快指针先走k-1次
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = null;
        for (int i = 1; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        while (fast != null) {
            if (slow == null) {
                slow = head;
            }else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
    }
}
