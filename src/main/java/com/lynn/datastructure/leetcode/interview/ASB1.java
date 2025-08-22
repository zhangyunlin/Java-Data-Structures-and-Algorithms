package com.lynn.datastructure.leetcode.interview;


import java.util.Arrays;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * content_copy
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class ASB1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 2,4}));
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        int index = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < 0) {
                index = i;
                continue;
            }
            if (A[i + 1] != A[i] && A[i + 1] - A[i] != 1) {
                index = i;
                break;
            }
            index = i+1;
        }
        if (A[index] < 0) {
            return 1;
        }
        return A[index] + 1;

    }


}
