package com.yuli.leetcode;

public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        boolean hasCycle = false;
        //有换的链表结尾不可能为空，如果为空就说明没有环
        while (fast.next != null && fast.next.next != null) {
            //慢指针没有走1
            slow = slow.next;
            //快指针每次走2
            fast = fast.next.next;
            //如果快慢指针一样，就说明有换
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        //如果存在环，就把慢指针移动到头节点，并且使两个速度都为1
        if (hasCycle) {
            slow = head;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
    }
}
