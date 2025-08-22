package com.lynn.datastructure.leetcode.medium;

import com.lynn.datastructure.msbedu.model.LinkedNode;

import java.util.HashMap;

/**
 * Get th intersection of two linked list
 * if exists, return the intersection node;
 * else, return null
 */
public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {

    }

    /*
    Add one of the linked list to Map,
    and then add another into the same Map,
    if can get the node from the Map, there exists a intersection
    else, no intersection
    time O(n)
    space O(n)
     */
    public static LinkedNode getIntersectionNode1(LinkedNode headA, LinkedNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        HashMap<LinkedNode, Integer> map = new HashMap<>();
        int count = 0;
        while (headA != null) {
            map.put(headA, count ++);
            headA = headA.next;
        }

        while (headB != null) {
            if (map.containsKey(headB)) {
                return headB;
            }else {
                map.put(headB, count ++);
            }
            headB = headB.next;
        }
        return null;
    }

    /*
    Get the length of lists
    diff is the length of two lists
    the long list move diff nodes, and then iterate the two lists
    time O(n)
    space O(1)
     */
    public static LinkedNode getIntersectionNode2(LinkedNode headA, LinkedNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int l1 = 0, l2 = 0;
        LinkedNode curA = headA, curB = headB;
        while (curA != null) {
            l1++;
            curA = curA.next;
        }
        while (curB != null) {
            l2++;
            curB = curB.next;
        }
        if (l1 > l2) {
            int diff = l1 - l2;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }else {
            int diff = l2 - l1;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null) {
            if (headB == headA) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /*
    Double pointer
    pointer A start from head A, iterate to the end of list A;
    then pointer move to head B, iterate to the end of list B;

    pointer B start from head B, iterate to the end of list B;
    then pointer B move to head A, iterate to the end of list A

    if there exists a node A equals node B, return the node
    else, return null
    time O(n)
    space O(1)
     */
    public static LinkedNode getIntersectionNode3(LinkedNode headA, LinkedNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        LinkedNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = curA.next;
            if (curA == null) {
                curA = headB;
            }
            curB = curB.next;
            if (curB == null) {
                curB = headA;
            }
        }
        return curA;
    }
}
