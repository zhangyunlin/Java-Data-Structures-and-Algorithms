package com.lynn.datastructure.leetcode;

/**
 * 总共n个硬币，排成阶梯状，保证第k行有k个硬币，并返回能够保证这个规则最大的行数
 * 例如：5个硬币，能够排成1/2/2，返回2
 */
public class CoinArrange {
    public static void main(String[] args) {
        System.out.println(arrangeCoins1(7));
        System.out.println(arrangeCoins2(7));
    }

    public static int arrangeCoins1(int n) {
        int[] arr = new int[n + 1];
        int count = 0;
        for (int i = 0; i <= n; i++) {
            arr[i] = i + 1;
            count += arr[i];
            if (count == n) {
                return arr[i];
            } else if (count > n) {
                return arr[i] -1;
            }
        }
        return arr[n];
    }

    //iterative
    public static int arrangeCoins2(int n) {
        int count = 0, sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
            count ++;
            if (sum == n) {
                return count;
            } else if (sum > n) {
                return count - 1;
            }
        }
        return count;
    }

    //subtraction
    public static int arrangeCoins3(int n) {
        for (int i = 1; i <= n; i++) {
            n -= i;
            if (n <= i) {
                return i;
            }
        }
        return 0;
    }

}
