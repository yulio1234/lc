package com.yuli.leetcode;

/**
 * 234. 回文链表
 * 采用双指针，
 * 1、将链表复制到一个数组，一个指针从头一个指针从尾遍历，比较是否相同，如果不相同就说明不是回文链表
 * 2、采用快慢指针，一个指针移动1，一个指针移动2，当2是尾节点或者null时，反转后半部分，并且将快指针指向头节点，进行比较。
 */
public class Leetcode234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head;
        //如果快指针不等于空或者快指针下一个节点不等于空就移动
        while (fast != null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果链表时奇数节点，就把正在归到左边
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseList(slow);//反转链表
        fast = head;//指向头节点
        //循环比较两个指针
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
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

    class ListNode {
        int val;
        ListNode next;
    }

}
