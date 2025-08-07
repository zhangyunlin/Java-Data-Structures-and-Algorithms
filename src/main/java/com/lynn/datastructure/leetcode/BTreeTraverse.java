package com.lynn.datastructure.leetcode;

import com.lynn.datastructure.leetcode.model.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyunlin
 */
public class BTreeTraverse {

    public static void main(String[] args) {

    }

    //
    public static void postorder(BTreeNode root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getVal() + " ");
        }
    }

    public static void levelOrder(BTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BTreeNode node = queue.poll();
            System.out.print(node.getVal() + " ");

            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }
}
