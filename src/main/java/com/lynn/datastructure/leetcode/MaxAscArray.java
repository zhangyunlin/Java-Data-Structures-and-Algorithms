package com.lynn.datastructure.leetcode;

//greedy algorithm
public class MaxAscArray {

    public static void main(String[] args) {
        System.out.println(maxAscArray(new int[]{1,2,3,2,3,4,5,3,4,5,6,7}));
    }

    public static int maxAscArray(int[] arr) {
        int max = 0;
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
