package com.yuli.leetcode;

/**
 * 160. 相交链表
 * 1、采用双指针，互相遍历两个链表，找到相同的节点或者null
 * 2、采用插值计算，获取两个链表节点的差值，较长的链表越过插值直接和短链表一起遍历，找到相交的链表
 */
public class Leetcode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //定义两个指针，分别只想a和b两个头节点
        ListNode pA = headA,pB = headB;
        /**
         * 如果a和b不相等，就访问下一个节点，如果节点访问完就只想另一个链表
         * 因为只有两种结果，有相交的就有相同的节点，没有相交的就最终都返回null
         * 在都返回null之前会保证所有节点都对比一次
         */
        while (pA != pB){
            pA = pA == null ? headB : pA.next;//如果a指针等于null就去访问b，不是的话就访问下一个节点
            pB = pB == null ? headA : pB.next;//如果b指针等于null就去访问a，不是的话就访问下一个节点

        }
        //返回null或者相同的节点
        return pA;
    }

    public class ListNode {
        int val;
        ListNode next;
    }
}
