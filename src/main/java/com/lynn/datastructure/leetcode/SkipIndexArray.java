package com.lynn.datastructure.leetcode;

/**
 * can not pick the adjacent  element from an array, and how to get the largest sum?
 */
public class SkipIndexArray {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 1};
        System.out.println(getMax(ints, ints.length - 1));
        System.out.println(getMaxPB(ints));
    }

    /*
    recursion
     */
    public static int getMax(int[] arr, int index) {
        if (arr == null || index < 0) {
            return 0;
        }
        if (index == 0) {
            return arr[0];
        }

        return Math.max(getMax(arr, index - 1), getMax(arr, index - 2) + arr[index]);
    }


    /**
     * dp
     *
     * @param arr
     * @return
     */
    public static int getMaxPB(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[arr.length - 1];
    }

    //降低空间复杂度
    public static int getMaxDp2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int first = arr[0], second = arr[1];
        for (int i = 2; i < arr.length; i++) {
            int temp = second;
            second = Math.max(first + arr[i], second);
            first = temp;
        }
        return second;
    }

    //如果数组是环形数组，首位相接
    public static int getMaxDp3(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        int first = arr[start], second = Math.max(arr[start + 1], arr[start ]);
        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + arr[i], second);
            first = temp;
        }
        return second;

    }


}
