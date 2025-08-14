package com.lynn.datastructure.msbedu;

import com.lynn.datastructure.msbedu.model.BNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BTreeAlgorithms {
    public static void main(String[] args) {
        BNode root = new BNode(5);
        root.left = new BNode(3);
        root.right = new BNode(7);
        root.left.left = new BNode(1);
        root.left.right = new BNode(4);
        root.right.left = new BNode(6);
        root.right.right = new BNode(9);
        root.right.right.left = new BNode(8);
        root.right.right.right = new BNode(10);
        System.out.println("pre order");
        preorderRecur(root);
        System.out.println("post order");
        postorderRecur(root);
        System.out.println("inorder");
        inorderRecur(root);
    }

    public static void traveral1(BNode root) {
        if (root == null) {
            return;
        }

        //traverse the BTree by recursion
        traveral1(root.left);
        traveral1(root.right);
    }

    /*
    在递归的基础上能够发展出前序遍历，后续遍历，中序遍历方法
    前序遍历preorder recursion root->left->right

     */
    public static void preorderRecur(BNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value+"");
        preorderRecur(root.left);
        preorderRecur(root.right);
    }

    /*
    中序遍历
    left->root->right
     */
    public static void inorderRecur(BNode root) {
        if (root == null) {
            return;
        }

        inorderRecur(root.left);
        System.out.println(root.value);
        inorderRecur(root.right);
    }

    /*
    后序遍历
    left->right->root
     */
    public static void postorderRecur(BNode root) {
        if (root == null) {
            return;
        }
        postorderRecur(root.left);
        postorderRecur(root.right);
        System.out.println(root.value);
    }


    /*
     * 使用非递归方式实现BTree遍历
     * 先序遍历 root->left->right
     * 1.从stack中弹出一个元素
     * 2.打印弹出节点
     * 3.先right再left
     * 重复以上步骤，完成遍历
     */
    public static void preorderStack(BNode root) {
        if (root == null) {
            return;
        }

        Deque<BNode> stack = new LinkedBlockingDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BNode head = stack.pop();
            System.out.println(head.value);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }

        }
    }

    /*
    inorder traversal without recursion
    left->right->root
     */
    public static void inorderStack(BNode root) {
        if (root == null) {
            return;
        }
        Deque<BNode> stack = new LinkedBlockingDeque<>();
        while (!stack.isEmpty() || root != null) {

            //left hand into stack
            if (root != null) {
                stack.push(root);
                root = root.left;

            }else { // traverse right hand
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
    }

    /*
    post order traversal without recursion

     */
    public static void postorderStack(BNode root) {
        if (root == null) {
            return;
        }

        Deque<BNode> stack1 = new LinkedBlockingDeque<>();
        Deque<BNode> stack2 = new LinkedBlockingDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BNode head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }
            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println((stack2.pop().value));
        }
    }

    /*
    计算树的宽度
     */
    public static int maxWidth(BNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = Integer.MIN_VALUE, currentLevelNodes = 0, curLevel = 1;
        HashMap<BNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root, 1);

        Queue<BNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BNode cur = queue.poll();
            Integer curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curNodeLevel ++;
            }else {
                maxWidth = Math.max(maxWidth, curNodeLevel);
                curLevel++;
                currentLevelNodes = 1;
            }
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return maxWidth;
    }

    /*
     * 如何判断一棵树是搜索二叉树？
     *
     */






}


