package com.lynn.datastructure.leetcode;

/**
 * give two strings, a and b, is a in b?
 */
public class StringSearch {
    public static void main(String[] args) {

    }

    //KMP 算法
    // 返回 text 中第一次出现 pattern 的起始下标；不存在则 -1
    public static int kmpSearchFirst(String text, String pattern) {
        // 与 String.indexOf("") 一致
        if (pattern.isEmpty()) {
            return 0;
        }
        if (text.isEmpty()){
            return -1;
        }

        int[] lps = buildLPS(pattern);
        // text 指针
        int i = 0;
        // pattern 指针
        int j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == pattern.length()) {
                    // 找到一次完整匹配
                    return i - j;
                }
            } else {
                if (j != 0) {
                    // 复用部分匹配信息
                    j = lps[j - 1];
                } else {
                    // 模式从头匹配
                    i++;
                }
            }
        }
        return -1;
    }

    // lps[i] = pattern[0..i] 的最长“真前缀==真后缀”的长度
    static int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;      // 当前最长前后缀长度
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // 继续尝试更短的前后缀
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
