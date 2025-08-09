package com.lynn.datastructure.msbedu;

import java.util.Arrays;


public class FindOddInArray {

    public static void main(String[] args) {
        System.out.println(findOnlyOddInArray(new int[]{2,2,2,3,3,3,3,4,4,4,4,4,4}));
        System.out.println(Arrays.toString(findTwoOddsInArray(new int[]{2,2,2,3,3,3,3,4,4,4,4,4,4,7})));


    }

    /**
     * there is only one number in an array appears in odd times,
     * how to find this number?
     */
    public static int findOnlyOddInArray(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }
        return num;
    }

    /**
     * there are 2 numbers in an array appears in odd times,
     * how to find these number?
     */
    public static int[] findTwoOddsInArray(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num ^ arr[i];
        }

        //num是32位的int， 必然有一位是1
        //提取出最右的1
//        int lowbit = num & (~num+1);
        int lowbit = num & -num;
        int oneOdd = 0;
        for(int cur : arr){
            if((cur & lowbit) == 1){
                oneOdd ^=cur;
            }
        }

        return new int[]{oneOdd,num^oneOdd};

    }



}
