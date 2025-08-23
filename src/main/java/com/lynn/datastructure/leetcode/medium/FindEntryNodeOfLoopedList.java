package com.lynn.datastructure.leetcode.medium;

import com.lynn.datastructure.msbedu.model.LinkedNode;

import java.util.HashSet;

/*
Find the entry node of a looped linked list
 */
public class FindEntryNodeOfLoopedList {
    public static void main(String[] args) {

    }

    /*
    Use a hash set to store all the nodes in a looped list,
    the first duplicate node is the entry of the loop
    time O(n)
    space 0(n)
     */
    public static LinkedNode findEntryNodeOfLoopedList1(LinkedNode head, int key) {
        LinkedNode current = head;
        HashSet<LinkedNode> set = new HashSet<>();
        while (current != null) {
            if (set.contains(current)) {
                return current;
            }
            set.add(current);
            current = current.next;
        }
        return null;
    }


    /*
    fast(node.next.next) and slow(node.next) pointer
    1. get the first meet node of fast and slow,
    2.leave the slow at the meet node, and set a pointer p1 to head
    3. get the first meet node of slow and p1, that is the entry point of loop
    slow path L + X
    fast path 2(L+X)
    the fast pointer traveled n circle more than the slow
    2(L+X) = L+X+nC
    2L+2X = L+X+nC
    L+X=nC
    L=nC-X=(n-1)C+Y
    if n = 1, then, L=Y
    the slow pointer and the pointer from the head will meet at the entry point

    time 0(n)
    space O(1)
     */
    public static LinkedNode findEntryNodeOfLoopedList2(LinkedNode head) {
        LinkedNode current = head, fast = head, slow = head;
        //get the first meet node of fast and slow
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        //move slow and cur pinter, and make them meet
        while (slow !=null && current != null) {
            if (slow == current) {
                return current;
            }
            slow = slow.next;
            current = current.next;
        }

        return null;
    }
}
