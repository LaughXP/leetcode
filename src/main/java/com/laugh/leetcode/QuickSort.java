package com.laugh.leetcode;

import java.util.Arrays;

/**
 * @author yu.gao 2019-04-09 2:19 PM
 */
public class QuickSort {

    private static void sort(int[] array, int left, int right) {
        if(array == null || array.length == 0 || array.length == 1) {
            return;
        }
        if(right -left <= 0) {
            return;
        }
        int pivot = partition(array, left, right);
        sort(array, left, pivot -1);
        sort(array, pivot + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = right;
        int pivotNum = array[pivot];
        right--;
        while (true) {
            while (array[left] < pivotNum) {
                left++;
            }
            while ((array[right] > pivotNum)) {
                right--;
            }
            if(left >= right) {
                break;
            } else {
                swap(array, left, right);
            }
        }
        swap(array, left, pivot);
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {65, 55, 45, 35, 25, 15, 10, 15};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
