package com.lynn.datastructure.leetcode;

public class PrimeStatistics {
    //Prime number statistics
    public static void main(String[] args) {
        int i = countPrimesByForce(100);
        System.out.println(i);
        int i1 = eratothenes(100);
        System.out.println(i1);
    }

    public static int countPrimesByForce(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = isPrime(i);
            if (flag) {
                count++;
            }
        }
        return count;
    }

    // 暴力算法
    public static boolean isPrime(int n) {
        //implement i square to enhance speed
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int eratothenes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                //j 就是合数的标记位
                for (int j = i * i; j < n; j += i) {
                   isPrime[j] = true;
                }
            }
        }

        return count;
    }


}
