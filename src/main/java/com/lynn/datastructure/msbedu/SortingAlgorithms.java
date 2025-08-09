package com.lynn.datastructure.msbedu;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));
        System.out.println(Arrays.toString(selectionSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));
        System.out.println(Arrays.toString(insertionSort(new int[]{2, 1, 4, 3, 10, 8, 7, 8, 6, 5})));

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

    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        return arr;

    }

    //等概率产生[0,n]随机数组
    public static int[] generateRandomArray(int size, int maxValue) {
        //长度随机的array
        int[] arr = new int[(int)((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue+1))-(int)(Math.random() * maxValue);
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
