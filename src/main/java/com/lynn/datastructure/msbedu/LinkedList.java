package com.lynn.datastructure.msbedu;


import com.lynn.datastructure.msbedu.model.LinkedNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * hash table
 * 1)哈希表在使用层面上可以理解为一种集合结构
 * 2)如果只有key，没有伴随致据value，可以使用HashSet结构(C++中叫Un0rderedSet)
 * 3)如果既有key，又有伴随效据value，可以使用HashMap结构(C++中叫Un0rderedWap)
 * 4)有无伴随数据，是HashMap和HashSet唯一的区别，底层的实际结构是一回事
 * 5)使用哈希表增(put)、剧(remove)、改(put)和查(get)的操作，可以认为时间复杂度为0(1)，但是常数时间比较大
 * 6)放入哈希表的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小
 * 7)放入哈希表的东西，如果不是基础类型，内部按引用传递，内存占用是这个东西内存地址的大小
 * <p>
 * 有序表介绍：
 * 1)有序表在使用层面上可以理解为一种集合结构
 * 2)如果只有key，没有伴随数据value，可以使用TreeSet结构(C++中叫0rderedSet)
 * 3)如果既有key，又有伴随数据value，可以使用TreeMap结构(C++中叫0rderedMap)
 * 4)有无伴随数据，是TreeSet和TreeMap难一的区别，底层的实际结构是一回事
 * 5)有序表和哈希表的区别是，有序表把key按照顺序组织起来，而哈希表完全不组织
 * 5)红黑树、AVL树、size-balance-tree和跳表等都属于有序表结构，只是底层具体实现不同
 * 6)放入哈希表的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小
 * 7)放入哈希表的东西，如果不是基础类型，必须提供比较器，内部按引用传递，内存占用是这个东西内存地址的大小
 * 8)不管是什么底层具体实现，只要是有序表，都有以下固定的基本功能和固定的时间复杂度
 */

public class LinkedList {
    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1, null);
        LinkedNode node2 = new LinkedNode(2, node1);
        LinkedNode node3 = new LinkedNode(3, node2);
        LinkedNode node4 = new LinkedNode(4, node3);
        LinkedNode node5 = new LinkedNode(3, node4);
        LinkedNode node6 = new LinkedNode(2, node5);
        LinkedNode node7 = new LinkedNode(1, node6);
//        LinkedNode head = reverseLinkedList(node7);
//        do {
//            System.out.println(head.value);
//            head = head.next;
//        } while (head != null);


//        boolean circle = isCircle(node7);
//        System.out.println(circle);

        System.out.println(isPalindrome(node7));
        System.out.println(isPalindrome2(node7));


    }

    /*
     *  reverse single link list
     */
    public static LinkedNode reverseLinkedList(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedNode prev = null;
        LinkedNode curr = head;
        while (curr != null) {
            LinkedNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /*
    whether the linked list has a circle
     */
    public static boolean isCircle(LinkedNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        LinkedNode slow = head;
        LinkedNode fast = head;
        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPalindrome(LinkedNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedNode cur = head;
        Stack<Integer> stack = new Stack<>();
        //add all elements to stack
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }

        //pop element
        while (!stack.isEmpty() ) {
            if (stack.pop() != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /*
    add half of the element into the stack
    Use extra space to store the value
     */
    public static boolean isPalindrome2(LinkedNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedNode slow = head, fast = head;

        // locate the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //if the length of the list is add, skip the middle
        if (fast != null) {
            slow = slow.next;
        }
        
        //push into stack
        Deque<Integer> stack = new ArrayDeque<>();
        for(LinkedNode cur = slow; cur != null; cur = cur.next) {
            stack.push(cur.value);
        }

        //iterate the nodes
        LinkedNode cur = head;
        while(!stack.isEmpty()) {
            if (stack.pop() != cur.value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /*
    reverse the rear half of the linked list, O(0) space
     */
    public static boolean isPalindrome3(LinkedNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //find middle
        LinkedNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the rear half
        LinkedNode rear = reverseLinkedList(slow.next);
        //compare the head and rear
        LinkedNode p1 = head, p2 = rear;
        while (p2 != null) {
            if (p1.value != p2.value) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //restore the list
        slow.next = reverse(rear);

        return true;
    }

    private static LinkedNode reverse(LinkedNode head) {
        LinkedNode prev = null, cur = head;
        while (cur != null) {
            LinkedNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }


}
