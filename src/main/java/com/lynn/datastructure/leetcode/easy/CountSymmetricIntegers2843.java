package com.lynn.datastructure.leetcode.easy;

import org.w3c.dom.ls.LSOutput;

public class CountSymmetricIntegers2843 {

    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = Math.max(low, 0); i <= high; i++){
            String str = String.valueOf(i);
            if(isTwoSum(str)){
                count ++;
            }
        }
        return count;
    }

    public boolean isPalindromic(String str){
        int i = 0, j = str.length()-1;
        while(i<j){
            if(str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static boolean isTwoSum(String str){
        if(str == null || str.isEmpty() || (str.length() & 1) == 1 ){
            return false;
        }

        int half = str.length()/2, sumL = 0, sumR = 0;
        for(int i = 0; i < half; i++){
            sumL += str.charAt(i)-'0';
        }

        for(int j = half; j < str.length(); j++){
            sumR += str.charAt(j)-'0';
        }

        return sumL == sumR;
    }
}
