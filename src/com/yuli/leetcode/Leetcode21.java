package com.yuli.leetcode;

/**
 * 合并两个有序链表
 * 采用双指针，循环对比两个链表，将两个里较小的放进结果集里
 */
public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode p = result;
        //有任何一个为空就结束
        while (list1 != null && list2 != null) {
            //如果l1较小，就把l1放进结果集里，并且把l1的指针向后挪动
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        //如果有集合不为空，就将集合里剩余的数据放在后面
        if (list1 != null) {
            p.next = list1;
        }
        if (list2 != null) {
            p.next = list2;
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
