package com.lynn.datastructure.msbedu;

import java.util.PriorityQueue;

import static com.lynn.datastructure.msbedu.BitwiseOperations.swap;

/**
 * 1. 堆结构是用数组实现的完全二叉树
 * 2. 完全二叉树每棵子树的最大值都在堆的顶部就是大根堆
 * 3. 完全二叉树中如果每棵子树的最小值都在顶部就是小根堆
 * 4. 堆结构最重要的操作是heapInsert和heapify操作
 * 5. 堆结构的增加--heapInsert, 堆结构减少--heapify, swap
 * 6. 优先队列结构，就是堆结构
 * @author zhangyunlin
 */
public class HeapSort {
    public static void main(String[] args) {

    }

    /**
     * heap sort
     * heap是一棵完全二叉树，每一层元素都是满的。
     * 大根堆--最大的元素是树的根
     * 小根堆--最小的元素是树的根
     * i 位置元素的父元素是（i-1）/2
     * heap insert: 插入元素与父元素比较，如果比父元素大，则交换当前元素与父元素的位置。
     * insert ele into heap
     */
    public static void heapInsert(int[] arr, int index) {
        // i 位置元素的父元素是（i-1）/2
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /*
    complete binary tree
    需求：返回堆中最大元素，并去掉最大元素
    实现思路：
    1.将最后加入堆的元素放入根位置
    2.heapSize - 1
    3.断开最后一个位置元素与堆的关系
    4.选择根的子节点中较大的节点，与根节点比较，并交换
    heapify方法将数组转化为堆
     */
    public static void heapify(int[] arr, int index, int heapSize) {
        // left child index
        int left = 2 * index + 1;

        // if there are more child elements exists
        while (left < heapSize) {
            //get the largest val in the two children nodes
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1]
                    ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    /*
     * heap sort 流程
     * 1. 将array变成大根堆--调用heapify方法
     * 2. 将根元素（最大值）与最右子节点数据（最小值）交换，并将heapSize-1, 将最大元素与堆断开，得到heapSize -1的堆，和最大的元素
     * 3. 最小值在堆中执行heapify方法，得到大根堆。递归重复2步骤，
     * 4.得到有序数组
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 1) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //将数组变为大根堆
    public static void arrayHeapify(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    /*
    note: 堆结构的重要性远高于堆排序

    已经存在树结构，但是不是大根堆，如何调整成大根堆？
    从最底层节点开始调用heapify方法，调整成小树大根堆，然后再向上调整成大根堆。
     */

    /*
    Q:已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
    并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
    Answer: HeapSort
    思路：
    1.使用小根堆数据结构，如果k=6 则表明每个元素的移动不会超过6位，可以建立一个k+1的小根堆；
    2.弹出堆顶元素，放入数组第一位，将第七个元素压入堆顶，依次向后执行这个操作，直到最后一个元素；
    3.自顶向下弹出堆中所有元素。
    排序结束
    O(nlogk) time, better than O(nlogn)
    java中的PriorityQueue就是小根堆的实现，可以直接使用
     */
    public static void heapSortArrayDistanceLessK(int[] arr, int k){
        if (arr == null || arr.length < 2) {
            return;
        }

        // use the default min heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int length = arr.length;
        int write = 0;

        // 1) 先把前 k+1 個元素入堆（不足就全部入堆）
        int i = 0;
        for (; i < Math.min(length, k + 1); i++) {
            heap.offer(arr[i]);
        }

        // 2) 迭代剩餘元素：每來一個新元素就彈出一個最小值寫回
        for (; i < length; i++) {
            Integer poll = heap.poll();
            arr[write++] = poll;
            heap.offer(arr[i]);
        }

        // 3) 清空堆，依序寫回
        while (!heap.isEmpty()) {
            arr[write++] = heap.poll();
        }
    }






}
