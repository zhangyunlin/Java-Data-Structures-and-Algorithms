package com.lynn.datastructure.msbedu.model;


import java.util.Objects;

/**
 * @author zhangyunlin
 */
public class LinkedNode {

    public int value;
    public LinkedNode next;

    public LinkedNode(int value, LinkedNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedNode node = (LinkedNode) o;
        return value == node.value && Objects.equals(next, node.next);
    }
}
