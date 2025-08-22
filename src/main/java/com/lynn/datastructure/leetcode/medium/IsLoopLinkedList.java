package com.lynn.datastructure.leetcode.medium;

import com.lynn.datastructure.msbedu.model.LinkedNode;

import java.util.HashSet;

/**
 * Can there be loops in a linked list?
 */
public class IsLoopLinkedList {

    public static void main(String[] args) {

    }

    /*
    use a HashSet to sore the list,
    and check whether the node is in the Set
    time O(n)
    space O(n)
     */
    public static boolean isLoop1(LinkedNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<LinkedNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /*
    use two pointer to iterate over the list
    time O(n)
    space O(1)
     */
    public static boolean isLoop2(LinkedNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        LinkedNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
