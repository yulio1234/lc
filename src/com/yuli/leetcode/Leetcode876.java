package com.yuli.leetcode;

/**
 * 876. 链表的中间结点
 * 采用快慢双指针，快指针每次都2，慢指针每次都1，当快指针等于尾节点或者null时返回慢指针
 */
public class Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;
    }
}
