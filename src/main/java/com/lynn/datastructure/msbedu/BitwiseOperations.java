package com.lynn.datastructure.msbedu;

import java.util.Arrays;

public class BitwiseOperations {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    /*
    how to swap two integer without a medium variant?
    XOR satisfies the commutative and associative laws.

    a = a ^ b
    b = a^b = a^b^b = a^0 = a
    a = a^b = a^b^a = b^0 = 0
    so, swap a and b without temp variant
     */
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }


}
