package com.lynn.datastructure.leetcode;

/**
 * Rreverse the array
 */
public class ArrayReverse {

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

    /*
     * reverse the array by iterate
     */
    public static ListNode reverseByIterate(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //reverse linked list by recurse
    public static ListNode reverseByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

//        ListNode head = reverseByIterate(node1);
        ListNode head = reverseByRecursion(node1);
         while (head != null){
            System.out.println(head.val);
            head = head.next;
        }


    }

}
