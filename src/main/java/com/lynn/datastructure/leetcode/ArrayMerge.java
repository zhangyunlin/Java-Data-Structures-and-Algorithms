package com.lynn.datastructure.leetcode;


import java.util.Arrays;

//merge two sorted arrays
public class ArrayMerge {

    public static void main(String[] args) {

    }

    //copy, sort, nlogn time
    public static int[] merge1(int[] a, int[] b) {
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(a);
        return a;
    }

    //two pointers
    public static int[] merge2(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int i = 0, j = 0,k=0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else if (a[i] > b[j]) {
                result[k++] = b[j++];
            }

        }
        return result;
    }

}
