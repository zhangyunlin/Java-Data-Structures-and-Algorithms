package com.lynn.datastructure.leetcode.model;


import lombok.Data;

@Data
public class BTreeNode {

    int val;
    BTreeNode left;
    BTreeNode right;

   public BTreeNode(int x) {
        this.val = x;
    }
}
