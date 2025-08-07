package com.lynn.datastructure.leetcode;

import com.lynn.datastructure.leetcode.model.BTreeNode;
import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * find the min depth of a btree
 */
public class BTreeSearch {

    public static void main(String[] args) {

    }

    //depth-first search
    public static int getDepth(BTreeNode root) {
        if (root == null){
            return 0;
        }

        int leftDepth = getDepth(root.getLeft());
        int rightDepth = getDepth(root.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }

    //Breadth-First Search
    public static int getDepthBFS(BTreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<BTreeNode> queue = new  LinkedList<BTreeNode>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BTreeNode node = queue.poll();
                if (node != null && node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node != null && node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            depth++;
        }
        return depth;
    }
}
