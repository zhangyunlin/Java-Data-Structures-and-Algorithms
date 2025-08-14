package com.lynn.datastructure.leetcode.easy;

/*
You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.


Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.


Constraints:

3 <= num.length <= 1000
num only consists of digits.
 */

import java.util.HashSet;

public class LargestGoodInteger2264 {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("111222333444"));
    }

    //brute force
    public static String largestGoodInteger(String num) {
        String[] patterns = new String[]{"000","111","222","333",
                "444","555","666","777","888","999"};
        HashSet<String> results = new HashSet<>();
        for(int i = 0; i<patterns.length; i++){
            if(num.contains(patterns[i])){
                results.add(patterns[i]);
            }
        }

        int count = Integer.MIN_VALUE;
        String max = "";
        for(String entry: results){
            int temp = Integer.parseInt(entry);
            if(temp > count){
                max = entry;
            }
        }
        return max;
    }


}
