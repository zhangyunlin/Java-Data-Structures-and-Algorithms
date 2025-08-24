package com.lynn.datastructure.leetcode.easy;

import com.lynn.datastructure.msbedu.model.LinkedNode;

/*
Get the middle of a linked list
 */
public class MiddleOfList {
    public static void main(String[] args) {

    }

    /*
    iterate for two times
    1.get the length of the list
    2.get the middle
    3.iterate get the middle
    time O(n)
    space O(1)
     */
    public static LinkedNode middleNode(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int middle = (int)Math.ceil(length / 2.0);
        for (int i = 0; i <=middle; i++) {
            head = head.next;
        }
        return head;
    }

    /*
     double pointer
     slow node.next, fast node.next.next
     when fast go the end of list, slow reaches the middle
     time O(n)
     space O(1)
     */
    public static LinkedNode middleNode2(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
