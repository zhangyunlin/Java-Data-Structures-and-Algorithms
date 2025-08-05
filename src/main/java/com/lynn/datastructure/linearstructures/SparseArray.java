package com.lynn.datastructure.linearstructures;

public class SparseArray {
    public static void main(String[] args) {
        /*
         * 将二位数组转化为稀疏数组
         */
        int[][] cheeseArray = new int[11][11];
        cheeseArray[1][2] = 1;
        cheeseArray[2][3] = 2;

        /*
         * print the 2-D array
         */
        for (int[] arr : cheeseArray){
            for(int i :arr ){
                System.out.printf("%d\t ", i);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < cheeseArray.length; i++) {
            for (int j = 0; j < cheeseArray[i].length; j++) {
                if (cheeseArray[i][j] != 0) {
                    sum ++;
                }
            }
        }

        // transfer data into sparse array
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = cheeseArray.length;
        sparseArray[0][1] = cheeseArray[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < cheeseArray.length; i++) {
            for (int j = 0; j < cheeseArray[i].length; j++) {
                if (cheeseArray[i][j] != 0) {
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = cheeseArray[i][j];
                }
            }
        }


        //print sparse array
        for (int[] ints : sparseArray) {
            System.out.printf("%d\t%d\t%d\n", ints[0], ints[1], ints[2]);
        }

    }
}
