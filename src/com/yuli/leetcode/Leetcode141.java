package com.yuli.leetcode;

/**
 * 141. 环形链表
 * 采用弗洛伊德算法，双指针不同速度循环，如果有相同的，就有环
 */
public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        //有换的链表结尾不可能为空，如果为空就说明没有环
        while (fast.next != null && fast.next.next != null) {
            //慢指针没有走1
            slow = slow.next;
            //快指针每次走2
            fast = fast.next.next;
            //如果快慢指针一样，就说明有换
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;
    }
}
