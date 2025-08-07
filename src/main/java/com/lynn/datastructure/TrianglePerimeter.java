package com.lynn.datastructure;

import java.util.Arrays;

//一个正整数数组，确定能够组成的三角形的最大边长
public class TrianglePerimeter {

    public static void main(String[] args) {
        System.out.println(maxPerimeter(new int[]{3,6,2,3}));
    }

    public static int maxPerimeter(int[] sides) {
        Arrays.sort(sides);
        for (int i = sides.length - 1; i >= 2 ; i--) {
            if (sides[i] < sides[i - 1] + sides[i - 2]) {
                return sides[i] + sides[i - 1] + sides[i - 2];
            }
        }
        return 0;
    }
}
