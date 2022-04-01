package com.yuli.leetcode;

/**
 * 206. 反转链表
 * 使用两个指针，一个是当前指针(指向头节点)，一个是前一个指针（初始为null），两个指针一起移动，把当前指针的节点指向前指针。
 */
public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;//前指针
        ListNode current = head;//当前指针
        while (current != null) {
            ListNode next = current.next;//保存当前节点的下一个节点
            current.next = pre;//当前节点的下一个改为前指针
            pre = current;//前指针记录当前节点
            current = next;//当前指针记录下一个计点
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;
    }
}
