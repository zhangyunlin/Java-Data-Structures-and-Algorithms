package com.lynn.datastructure.msbedu.hash;

import java.util.HashMap;

/**
 * 设计RandomPool结构
 * 【题目】
 * 设计一种结构，在该结构中有如下三个功能:
 * insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key):将原本在结构中的某个key移除
 * getRandom():等概率随机返回结构中的任何一个key。
 * 【要求】
 * Insert、delete和getRandom方法的时间复杂度都是0(1)
 */
public class RandomPool {

    /*
    思路:
    1.设计一个hash函数，或者选择一个hash函数，对每个key进行hash计算；
    2.初始化一个array，存储类型为链表，用array.length对hash取模，结果范围[0,array.length-1]
    3.将对应值存储存入链表，且array中存储该链表节点。
     */

    /*
    思路2：
    1.数据中两个HashMap<String, index>, HashMap<index, String>, int size=0;
    2. insert("str") 的时候，在第一个Map中存入str,以及存入的index，比如str第一个存入，则index=0, size =1;
    3. delete("str") 的时候，在第一个Map中删除对应记录，并将最后一条记录移动到删除位置，确保index数列中间不出现空洞；
    第二个Map中也执行相同的操作，保证index序列不出现空洞。
    4. getRandom()时，
     */

    public static class Pool<K>{
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool(){
            this.keyIndexMap = new HashMap<>();
            this.indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key){
            if (!keyIndexMap.containsKey(key)){
                keyIndexMap.put(key, this.size);
                indexKeyMap.put(this.size++, key);
            }
        }

        public void delete(K key){
            if (keyIndexMap.containsKey(key)){
                Integer deleteIndex = this.keyIndexMap.get(key);
                int lastIndex = --this.size;
                K lastKey = indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom(){
            if (this.size == 0){
                return null;
            }

            int randomIndex = (int)(Math.random() * this.size);
            return this.indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {

    }
}
