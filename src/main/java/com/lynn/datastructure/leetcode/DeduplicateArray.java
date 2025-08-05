package com.lynn.datastructure.leetcode;

/**
 * 双指针算法
 * 不能使用额外的数组空间，必须在原地修改输入数组
 */
public class DeduplicateArray {
    public static void main(String[] args) {
        System.out.println(deduplicateArray(new int[]{0,1,2,3,4,4,4,4,5}));
    }

    public static int deduplicateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        // slow index
        int j = 0;
        //fast index
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j ++;
                arr[j] = arr[i];
            }
        }

        // 返回数组长度
        return j+1;
    }




}
