package com.lynn.datastructure.msbedu.btree;

import com.lynn.datastructure.msbedu.model.BNode;

import java.util.LinkedList;

/**
 * check a BTree is a complete binary tree
 * 二叉树按宽度遍历
 * 1)如果遇到节点有右child，没有left child, return false
 * 2)在满足1)情况下，如果遇到left child 和right child不同时存在得情况下，这些节点一定是叶子节点
 *
 * @author zhangyunlin
 */
public class CheckCBT {
    public static void main(String[] args) {

    }

    /*

     */
    public static boolean checkCBT(BNode root) {
        if (root == null){
            return true;
        }

        //宽度优先遍历
        LinkedList<BNode> queue = new LinkedList<>();
        //是否遇到过左右两个子节点不全的情况
        boolean leaf = false;
        BNode left = null, right = null;
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            left = root.left;
            right = root.right;
            if ((leaf && (left != null || right != null)) //如果遇到不双全的节点，又发现当前节点居然有子节点，不是叶子节点
                    || (left == null && right != null)) { //
                return false;
            }

            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }



}
