package com.lynn.datastructure.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Find indices of two nums in an array that make a given target
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSumByMap(new int[]{1, 2, 2, 3, 5, 6, 4}, 5);
        System.out.println(Arrays.toString(ints));
    }

    //bi-pointer to do two sum
    public static int[] twoSumBy2Pointer(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }


        //only for the sorted array
        Arrays.sort(nums);

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return null;
    }

    //binary search to do two sum
    public static int[] twoSumBinary(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return null;
    }


    //use hashset to returen the numbers that make the target, O(n) time
    public static int[] twoSumBySet(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (set.contains(complement)) {
                return new int[]{num, complement};
            }
            set.add(num);
        }
        return null;
    }

    //brute force, O(n²) time
    public static int[] twoSumByForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //hashMap to get to indics O(n) time
    public static int[] twoSumByMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        //Value as key, and index as value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
