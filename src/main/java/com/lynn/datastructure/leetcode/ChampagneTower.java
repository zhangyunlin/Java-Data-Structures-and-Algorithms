package com.lynn.datastructure.leetcode;

/**
 * pour wine to a champagne tower,
 * get the r line l row status
 */
public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println(champagneTower(5, 2, 1));
    }

    public static double champagneTower(int poured, int queryRow, int queryGlass) {
        double[][] tower = new double[100][100];
        tower[0][0] = poured;
        for (int i = 0; i < queryRow; i++) {
            for (int j = 0; j < i; j++) {
                double d = (tower[i][j] -1.0)/2;
                if (d > 0){
                   tower[i+1][j] += d;
                   tower[i+1][j+1] += d;
                }
            }
        }

        return Math.min(tower[queryRow][queryGlass], 1.0d);
    }
}
