package com.lynn.datastructure.msbedu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * bucket sort
 * 基数排序  -- radix sort
 * 计数排序 -- counting sort
 * 1. bucket sort不基于比较的排序
 * 2. O(n) time
 * 3.应用范围有限，需要样本数据安祖桶的划分
 * @author zhangyunlin
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] a = {29,25,3,49,9,37,21,43};
        bucketSort(a, 10);
        System.out.println(Arrays.toString(a));
    }

    /*
     * bucket sort应用限制：
     * 1. 数据范围有限，
     * 2. 基于数据范围建立bucket, 并在每个bucket上统计数据频率（计数），
     * 3. 将每个bucket的词频（计数）展开，就得到排序结果
     */

    /*
    基数排序 radix sort
     */
    // arr 中的数大致在 0..99；bucketCount 可调，比如 10/20
    public static void bucketSort(int[] arr, int bucketCount) {
        if (arr == null || arr.length <= 1) return;

        // 1) 创建桶
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        // 2) 分桶（这里按十分位分：0-9、10-19...）
        for (int x : arr) {
            int idx = Math.min(x / (100 / bucketCount), bucketCount - 1); // 防越界
            buckets.get(idx).add(x);
        }

        // 3) 桶内排序（元素不多，用 Collections.sort 即可）
        int write = 0;
        for (List<Integer> b : buckets) {
            // 桶内可换成插入排序
            Collections.sort(b);
            for (int v : b) {
                arr[write++] = v;
            }
        }
    }

}
