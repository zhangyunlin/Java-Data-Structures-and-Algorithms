package com.lynn.datastructure.leetcode;

import java.util.Arrays;

/**
 * find the middle index of an array
 * to ensure sum of the left equals the sum of the right
 *
 * sum the whole array,
 * use an index from  the left to do iteration, total ada the item, and sum subtract the item
 * when total equals sum,
 * get the middle index
 */
public class FindArrayMiddleIndex {

    public static void main(String[] args) {
        System.out.println(getMiddle(new int[]{7,7,3,5,6,6}));
    }

    public static int getMiddle(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int sum = Arrays.stream(arr).sum();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            sum -= arr[i];
            if (total == sum) {
                return i;
            }
        }
        return -1;
    }

}
