package com.laugh.sort;

import java.util.Arrays;

/**
 * @author yu.gao 2019-04-09 2:19 PM
 */
public class SelectionSort {

    public static int[] sort(int[] array) {
        if(array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        for(int i = 0; i < array.length; i++) {
            int lowest = i;
            for(int j = i+1; j < array.length; j++) {
                if(array[j] < array[lowest]) {
                    lowest = j;
                }
            }
            if(lowest != i) {
                int tmp = array[i];
                array[i] = array[lowest];
                array[lowest] = tmp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {65, 55, 45, 35, 25, 15, 10, 15})));
    }
}
