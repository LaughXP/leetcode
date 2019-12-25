package com.laugh.sort;

import java.util.Arrays;

/**
 * @author yu.gao 2019-04-09 10:27 AM
 */
public class BubbleSort {

    private static int[] sort(int[] array) {
        if(array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        boolean sorted = false;
        int maxIndex = array.length - 1;
        while (!sorted) {
            sorted = true;
            for( int i = 0; i < maxIndex; i++) {
                if(array[i] > array[i+1]) {
                    sorted = false;
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
            maxIndex--;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {65, 55, 45, 35, 25, 15, 10, 15})));
    }
}
