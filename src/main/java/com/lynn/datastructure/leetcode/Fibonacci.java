package com.lynn.datastructure.leetcode;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(10));
        System.out.println(fib3(10));
    }

    //brute force, recursive
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    //arr to store the value
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    //fib by iterative
    public static int fib3(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

}
