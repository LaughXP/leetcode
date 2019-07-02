package com.laugh.leetcode;

/**
 * @author yu.gao 2019-05-16 9:55 AM
 */
public class BinarySearch {

    public static Integer search(int[] array, int k) {
        if(array == null || array.length == 0) {
            return null;
        }
        int lowerBound = 0;
        int upperBound = array.length - 1;

        while (lowerBound <= upperBound) {
            int middleBound = (lowerBound + upperBound) / 2;
            int valueAtMiddle = array[middleBound];
            if(k < valueAtMiddle) {
                upperBound = middleBound - 1;
            } else if(k > valueAtMiddle) {
                lowerBound = middleBound + 1;
            } else {
                return middleBound;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3,4,5,6}, 7));
    }
}
