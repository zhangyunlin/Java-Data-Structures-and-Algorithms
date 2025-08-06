package com.lynn.datastructure.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/*
To get the maximum sum in an array,
the most common problem is finding the maximum subarray sum, which means the largest sum
of contiguous elements in the array.
This is solved by Kadane's Algorithm, which works in linear time O(n).
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        System.out.println(maxSubArray1(new int[]{1,2,4,3,5,7,6,3,2},3));
        System.out.println(maxSubArray2(new int[]{1,2,4,3,5,7,6,3,2},3));
    }

    public static int maxSubArray1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = Integer.MIN_VALUE;
        int currentSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k; i++) {
            currentSum = Arrays.stream(nums, i, i + k).sum();
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }

        return maxSoFar;
    }

    //sliding window
    public static int maxSubArray2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = Integer.MIN_VALUE;

        int maxSoFar = Arrays.stream(nums, 0, k).sum();

        //sliding window
        for (int i = k; i < nums.length ; i++) {
            currentSum = maxSoFar - nums[i - k] + nums[i ];
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }
        return maxSoFar;
    }


}
