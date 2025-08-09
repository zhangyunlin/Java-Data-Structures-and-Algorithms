package com.lynn.datastructure.msbedu;

public class SearchAlgorithms {
    public static void main(String[] args) {

    }

    //O(logN)
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid] < target) {
                low = mid + 1;
            }else if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        // can not find target in the array
        return -1;
    }


}
