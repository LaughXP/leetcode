package com.laugh.sort;

import java.util.Arrays;

/**
 * @author yu.gao 2019-04-09 2:19 PM
 */
public class InsertionSort {

    public static int[] sort(int[] array) {
        if(array == null || array.length == 0 || array.length == 1) {
            return array;
        }
        for(int i = 1; i < array.length; i++) {
            int now = i;
            int tmp = array[i];
            while (now > 0 && array[now - 1] > tmp) {
                array[now] = array[now -1];
                now--;
            }
            array[now] = tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[] {65, 55, 45, 35, 25, 15, 10, 15})));
    }
}
