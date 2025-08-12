package com.lynn.datastructure.msbedu.model;

import java.util.Objects;

public class LinkedRandNode {
    public int value;
    public LinkedRandNode next;
    public LinkedRandNode rand;

    public LinkedRandNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedRandNode that = (LinkedRandNode) o;
        return value == that.value && Objects.equals(next, that.next) && Objects.equals(rand, that.rand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next, rand);
    }
}
