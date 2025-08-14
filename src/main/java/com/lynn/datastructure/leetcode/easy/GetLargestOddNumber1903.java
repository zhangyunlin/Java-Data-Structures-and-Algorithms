package com.lynn.datastructure.leetcode.easy;

/**
 * @author zhangyunlin
 */
public class GetLargestOddNumber1903 {

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
    }
    public static String largestOddNumber(String num) {
        for(int i = num.length()-1; i >= 0; i--){
            char c = num.charAt(i);
            if((c-'0')%2 != 0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
