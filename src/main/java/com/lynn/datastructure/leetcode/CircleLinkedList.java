package com.lynn.datastructure.leetcode;

import java.util.HashSet;

/*
给定一个链表，判断是否有环
链表中某个节点的指针是否指向之前的节点，如果指向之前的节点，则是有环链表
 */
public class CircleLinkedList {

    /*
inner class to define the linked list
*/
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node3;


        System.out.println(isLoop(node1));
        System.out.println(isLoop2(node1));

    }


    // set
    public static boolean isLoop(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (!nodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //double pointer
    public static boolean isLoop2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
