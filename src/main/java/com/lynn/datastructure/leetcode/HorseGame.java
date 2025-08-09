package com.lynn.datastructure.leetcode;

import java.awt.*;
import java.util.*;

/**
 * 田忌赛马，贪心算法
 */
public class HorseGame {
    public static void main(String[] args) {
        int[] a = new int[]{10,24,8,32};
        int[] b = new int[]{10,24,8,32};
        System.out.println(Arrays.toString(horseGame(a, b)));
    }

    /**
     * premise: a.length = b.length
     * if a[i] > b[i] then a get one point, how to arrange the a array to make the max points?
     * @param a
     * @param b
     * @return
     */
    public static int[] horseGame(int[] a, int[] b) {
        Arrays.sort(a);
        int[] sortedB = b.clone();
        Arrays.sort(sortedB);

        HashMap<Integer, Deque<Integer>> bmap = new HashMap<>();
        for (int num: b) {
            bmap.put(num, new LinkedList<>());
        }

        Deque<Integer> aQueue = new LinkedList<>();
        int j = 0;
        for (int aNum: a) {
            if (aNum > sortedB[j]){
                bmap.get(sortedB[j++]).add(aNum);
            }else {
                aQueue.add(aNum);
            }
        }

        int[] ans = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            if (!bmap.get(b[i]).isEmpty()) {
                ans[i] = bmap.get(b[i]).getLast();
            }else {
                ans[i] = aQueue.removeLast();
            }
        }

        return ans;
    }
}
