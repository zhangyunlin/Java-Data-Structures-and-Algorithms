package com.lynn.datastructure.leetcode;

/**
 * get the square of X without Math.Sqrt()
 * binary search and Newton iteration
 */
public class SquareX {
    public static void main(String[] args) {
        System.out.println(squareBinarySearch(25));
        System.out.println(squareNewtonSearch(25));
    }

    public static int squareBinarySearch(int n) {
        //二分法查找
        int index = -1, r = n, l = 0;
        while (l <= r){
            int m = (l+r)/2;
            if (m * m <= n){
                index = m;
                l = m + 1;
            }else {
                r = m - 1;
            }
        }
        return index;
    }

    public static int squareNewtonSearch(int n) {
        if (n == 0){
            return 0;
        }
        return (int)squrt(n, n);
    }

    public static double squrt(double i, int x){
        double res = (i + x/i)/2;
        if (res == i){
            return i;
        } else {
            return squrt(res, x);
        }
    }


}
