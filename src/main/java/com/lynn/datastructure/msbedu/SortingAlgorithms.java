package com.lynn.datastructure.msbedu;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));
        System.out.println(Arrays.toString(selectionSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));
        System.out.println(Arrays.toString(insertionSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));

    }

    //O(n^2)
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //O(n^2)
    public static int[] selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    //O(n^2)
    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                arr[j] = arr[j + 1] ^ arr[j];
                arr[j + 1] = arr[j + 1] ^ arr[j];
                arr[j] = arr[j + 1] ^ arr[j];
            }
        }
        return arr;
    }

    /**
     * O(NlogN) time
     * sort right and left at the first step
     * then merge right and left
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        process(arr, 0, arr.length - 1);
        return arr;

    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
//        int mid = L + ((R - L) >> 1);
        int mid = (L + R) >>> 1;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0, p1 = L, p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[L + j] = temp[j];
        }
    }

    /**
     * given an array, and an integer num
     * put all numbers that smaller than num to the right
     * put all numbers that greater than num to the left
     * require: O(1) space, 0(n) time
     *
     * @param size
     * @param maxValue
     * @return
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        quickSort(arr, 0,  arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //随机选择划分的数，用于区分大于小于部分
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    private static void swap(int[] arr, int i, int r) {
        BitwiseOperations.swap(arr, i, r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1; // <区边界
        int more = r; //> 区边界
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, l);
        return new int[]{less + 1, more};
    }


    //等概率产生[0,n]随机数组
    public static int[] generateRandomArray(int size, int maxValue) {
        //长度随机的array
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    //for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return arr;
        }
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }



}
