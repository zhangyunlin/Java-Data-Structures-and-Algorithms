package com.lynn.datastructure.leetcode;

import java.util.Arrays;

/**
 * get the max product value of three items in an array
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1, 2, 3, 4, 5, 6, -9, -8}));
        System.out.println(maxProductBySort(new int[]{1, 2, 3, 4, 5, 6, -9, -8}));
    }

    //linear search
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //最大的三个正数
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        //最小的两个负数
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        //update the bigest value
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            //update the min values
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }


    //sort the array
    public static int maxProductBySort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
