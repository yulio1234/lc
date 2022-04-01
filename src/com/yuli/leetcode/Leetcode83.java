package com.yuli.leetcode;

/**
 * 83. 删除排序链表中的重复元素
 */
public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode point = head;
        while (point.next != null) {
            if (point.val == point.next.val) {
                point.next = point.next.next;
            } else {
                point = point.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
