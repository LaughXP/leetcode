package com.laugh.leetcode;

import java.util.Arrays;

/**
 * @author yu.gao 2019-04-10 10:58 AM
 */
public class QuickSelect {

    private static int select(int[] array, int k, int left, int right) {
        if(right -left <= 0) {
            return array[left];
        }
        int pivot = partition(array, left, right);
        if( k < pivot) {
            return select(array, k, left, pivot -1);
        } else if(k > pivot) {
            return select(array, k, pivot + 1, right);
        } else {
            return array[pivot];
        }
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
        int[] array = new int[] {0, 50, 20, 10, 60, 30};
        System.out.println(select(array, 1,0, array.length - 1));
        System.out.println(Arrays.toString(array));
    }
}
