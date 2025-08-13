package com.lynn.datastructure.msbedu.model;

import java.util.Objects;

public class BNode {
    public int value;
    public BNode left;
    public BNode right;

    public BNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BNode bNode = (BNode) o;
        return value == bNode.value && Objects.equals(left, bNode.left) && Objects.equals(right, bNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}
