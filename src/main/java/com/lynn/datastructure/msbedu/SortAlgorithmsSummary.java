package com.lynn.datastructure.msbedu;

import java.util.Arrays;

public class SortAlgorithmsSummary {

        /*
    排序算法的穩定性及其汇总
    同样值的个体之间，如果不因为排序而改变相对次序，就是这个排序是有稳定的;否则就没有。
    不具备稳定性的排序:
    选择排序、快速排序、堆排序
    具备稳定性的排序:
    冒泡排序、插入排序、归并排序、一切桶排序思想下的排序
    目前没有找到时间复杂度0(N*IogN)，额外空间复杂度0(1)，又稳定的排序。

    排序算法常见的坑：
    1，归并排序的额外空间复杂度可以变成0(1)，但是非常难，不需要掌握，有兴趣可以搜“归并排序 内部缓存法”
    2.“原地归并排序”的帖子都是垃圾，会让归并排序的时间复杂度变成0(N~2).
    3，快速排序可以做到稳定性问题，但是非常难，不需要掌握，可以搜“01 stable sort
    4，所有的改进都不重要，因为目前没有找到时间复杂度0(N*I0gN)，额外空间复杂度0(1)，又稳定的排序。
    5，有一道题目，是奇数放在数组左边，偶数放在数组右边，还要求原始的相对次序不变，O(N) time, O(1) space.碰到这个问题，可以怼面试官。
    经典的partition比较大小，是0-1问题，和区分奇偶性是一样的，但是经典的快排算法做不到。可以请求面试官教你解这个问题。
     */

    /*
    排序算法对比：
    冒泡排序 (Bubble Sort)	    O(n²)	    O(1)	        ✅ 稳定	相邻元素比较交换，数据量小可用
    选择排序 (Selection Sort)	O(n²)	    O(1)	        ❌ 不稳定	每次选择最小值放到前面
    插入排序 (Insertion Sort)	O(n²)	    O(1)	        ✅ 稳定	数据量小、基本有序时效率高
    希尔排序 (Shell Sort)	    O(n^(3/2))	O(1)	        ❌ 不稳定	插入排序的优化版
    归并排序 (Merge Sort)	    O(n log n)	O(n)	        ✅ 稳定	需要额外数组，适合链表
    快速排序 (Quick Sort)	    O(n log n)	O(log n)~O(n)	❌ 不稳定	平均最快，分治思想
    堆排序 (Heap Sort)	        O(n log n)	O(1)	        ❌ 不稳定	适合求第 K 大/小元素
    计数排序 (Counting Sort)	    O(n + k)	O(k)	        ✅ 稳定	适合整数且范围不大
    桶排序 (Bucket Sort)	        O(n + k)	O(n + k)	    ✅ 稳定(桶内用稳定排序)	数据分布均匀时快
    基数排序 (Radix Sort)	    O(n·k)	    O(n + k)	    ✅ 稳定	按位数排序，适合整数/字符串
     */

    /*
    工程上对排序的改进：
    1.充分利用O(NlogN)和O(N^2)排序的优势
    2.考虑稳定性
    eg: 快速排序结合插入排序，当元素少于60时，使用插入排序。
     */

    private static final int CUTOFF = 60;

    public static void sort(int[] a) {
        if (a == null || a.length < 2) return;
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int L, int R) {
        while (L < R) {
            // 小区间插入排序
            if (R - L + 1 <= CUTOFF) {
                insertionSort(a, L, R);
                return;
            }
            int p = partitionMedian3(a, L, R);
            // 尾递归优化：总是先处理较小的一侧
            if (p - 1 - L < R - (p + 1)) {
                quickSort(a, L, p - 1);
                L = p + 1;
            } else {
                quickSort(a, p + 1, R);
                R = p - 1;
            }
        }
    }

    // 三数取中 + Lomuto/Hoare 皆可，这里给 Hoare 风格
    private static int partitionMedian3(int[] a, int L, int R) {
        int m = L + ((R - L) >>> 1);
        // 三数取中：把中值放到 L 位置
        if (a[m] < a[L]) {
            swap(a, m, L);
        }
        if (a[R] < a[L]) {
            swap(a, R, L);
        }
        if (a[R] < a[m]) {
            swap(a, R, m);
        }
        // 现在 a[L] 为中值
        swap(a, L, m);
        int pivot = a[L];

        int i = L - 1, j = R + 1;
        while (true) {
            do { i++; } while (a[i] < pivot);
            do { j--; } while (a[j] > pivot);
            // 返回分割点（Hoare 返回上半区最后位置）
            if (i >= j) {
                return j;
            }
            swap(a, i, j);
        }
    }

    private static void insertionSort(int[] a, int L, int R) {
        for (int i = L + 1; i <= R; i++) {
            int x = a[i], j = i - 1;
            while (j >= L && a[j] > x) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;
        }
    }

    private static void swap(int[] a, int i, int j) {
        if (i != j) { int t = a[i]; a[i] = a[j]; a[j] = t; }
    }

    // quick demo
    public static void main(String[] args) {
        int[] arr = {5,1,9,3,7,6,2,8,4,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
