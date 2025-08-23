package com.lynn.datastructure.leetcode.medium;

import com.lynn.datastructure.msbedu.model.LinkedNode;

/**
 * Merge two sorted list
 */
public class MergeSortedList {

    public static void main(String[] args) {

    }

    /*
    Use an anchor node to record the head of the node
    time O(n)
    space O(1)
     */
    public static LinkedNode mergeSortedLists1(LinkedNode head1, LinkedNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        LinkedNode pt1 = head1, pt2 = head2;
        LinkedNode anchor = new LinkedNode(0, null);
        LinkedNode tail = anchor;

        while (pt1 != null && pt2 != null) {
            if (pt1.value < pt2.value) {
                tail.next = pt1;
                pt1 = pt1.next;
            }else {
                tail.next = pt2;
                pt2 = pt2.next;
            }
            tail = tail.next;
        }
        //add the remainder
        tail.next = pt1 == null ? pt2 : pt1;

        return anchor.next;
    }

    /*
    recursion
    time O(n)
    space 0(1)
     */
    public static LinkedNode mergeSortedLists2(LinkedNode head1, LinkedNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        if (head1.value < head2.value) {
            head1.next = mergeSortedLists2(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSortedLists2(head1, head2.next);
            return head2;
        }
    }

}
