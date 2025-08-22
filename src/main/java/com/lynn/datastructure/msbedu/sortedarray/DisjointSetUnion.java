package com.lynn.datastructure.msbedu.sortedarray;

import java.util.HashMap;
import java.util.Objects;

/**
 * 并查集
 * 如何快速查询一个set是否在同一个集合中？
 * 如何实现集合快速合并？
 *
 * 使用图来实现
 */
public class DisjointSetUnion {
    public static void main(String[] args) {

    }

    public static class Element<V>{
        public V value;
        public Element(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element<?> element = (Element<?>) o;
            return Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value);
        }
    }

    public static class UnionFindSet<V>{
        public HashMap<V,Element<V>> elementMap;
        //key 某个元素，value 该元素的父
        public HashMap<Element<V>,Element<V>> fatherMap;
        //key 某个集合的代表元素，value 该集合的大小
        public HashMap<Element<V>,Integer> sizeMap;

        
    }


}
