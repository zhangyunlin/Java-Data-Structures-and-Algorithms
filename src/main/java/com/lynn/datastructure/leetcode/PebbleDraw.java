package com.lynn.datastructure.leetcode;

import java.util.Arrays;

/**
 * an array has even elements, and odd sum
 * a player can draw element from the head or from the tail
 * can you tell who will be the winner?
 */
public class PebbleDraw {
    public static void main(String[] args) {
        int[] ints = {1, 3, 3, 5, 6, 7};
        int sum = Arrays.stream(ints).sum();
        int score = maxScore(ints, 0, ints.length - 1);
        System.out.println(score > sum - score);
    }

    public static int maxScore(int[] ints, int l, int r) {
        if (l == r) {
            return ints[l];
        }
        int sLeft = 0, sRight = 0;
        if (r - l == 1) {
            sLeft = ints[l];
            sRight = ints[r];
        }
        if (r - l == 2) {
            sLeft = ints[l] + Math.min(maxScore(ints, l + 2, r), maxScore(ints, l + 1, r - 1));
            sRight = ints[r] + Math.min(maxScore(ints, l + 1, r - 1), maxScore(ints, l, r - 2));
        }
        return Math.max(sLeft, sRight);
    }

    public static int maxScoreOpt(int[] ints, int l, int r) {
        if (l == r) {
            return ints[l];
        }
        int sLeft = 0, sRight = 0;
        if (r - l == 1) {
            sLeft = ints[l];
            sRight = ints[r];
        }
        if (r - l == 2) {
            int temp = maxScore(ints, l + 1, r - 1);
            sLeft = ints[l] + Math.min(maxScore(ints, l + 2, r), temp);
            sRight = ints[r] + Math.min(temp, maxScore(ints, l, r - 2));
        }
        return Math.max(sLeft, sRight);
    }

    public static int maxScoreDynamic(int[] ints, int l, int r) {
        if (l == r) {
            return ints[l];
        }
        int sLeft = ints[l] - maxScoreOpt(ints, l + 1, r);
        int sRight = ints[r] - maxScoreOpt(ints, l , r -1);
        return Math.max(sLeft, sRight);
    }

    //dynamical planning
    public static boolean maxScoreDynamicOpt(int[] ints) {
        int[][] dp = new int[ints.length][ints.length];
        //initialize the dp matrix
        for (int i = 0; i < ints.length; i++) {
            dp[i][i] = ints[i];
        }

        //get all diffs
        for (int i = ints.length -2; i >= 0; i--) {
            for (int j = i + 1; j < ints.length; j++) {
                dp[i][j] = Math.max(ints[i] - dp[i+1][j], ints[j] - dp[i][j-1]);
            }
        }

        return dp[0][ints.length - 1] >= 0;
    }
}
