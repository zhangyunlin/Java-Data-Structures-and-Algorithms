package com.lynn.datastructure.msbedu;

public class RecursiveAlgorithms {
    public static void main(String[] args) {


    }

    //get mac value between left and right in array
    public static int getMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }

        int mid = left + (right-left) >> 1;
        int leftMax = getMax(arr, left, mid);
        int rightMax = getMax(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }


}
