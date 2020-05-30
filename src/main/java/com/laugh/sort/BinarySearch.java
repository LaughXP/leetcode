package com.laugh.sort;

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
            int middleBound = lowerBound + ((upperBound - lowerBound) >> 1);
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

    //查找第一个等于给定值的元素
    public static Integer searchFirstEq(int[] array, int k) {
        if(array == null || array.length == 0) {
            return null;
        }
        int lowerBound = 0;
        int upperBound = array.length - 1;

        while (lowerBound <= upperBound) {
            int middleBound = lowerBound + ((upperBound - lowerBound) >> 1);
            int valueAtMiddle = array[middleBound];
            if(k < valueAtMiddle) {
                upperBound = middleBound - 1;
            } else if(k > valueAtMiddle) {
                lowerBound = middleBound + 1;
            } else {
                if(middleBound == 0 || array[middleBound - 1] != k) {
                    return middleBound;
                }else {
                    upperBound = middleBound - 1;
                }
            }
        }
        return null;
    }

    //查找最后一个等于给定值的元素
    public static Integer searchLastEq(int[] array, int k) {
        if(array == null || array.length == 0) {
            return null;
        }
        int lowerBound = 0;
        int upperBound = array.length - 1;

        while (lowerBound <= upperBound) {
            int middleBound = lowerBound + ((upperBound - lowerBound) >> 1);
            int valueAtMiddle = array[middleBound];
            if(k < valueAtMiddle) {
                upperBound = middleBound - 1;
            } else if(k > valueAtMiddle) {
                lowerBound = middleBound + 1;
            } else {
                if(middleBound == array.length -1 || array[middleBound + 1] != k) {
                    return middleBound;
                }else {
                    lowerBound = middleBound + 1;
                }
            }
        }
        return null;
    }

    //查找最后一个小于等于给定值的元素
    public static Integer searchLastLtEq(int[] array, int k) {
        if(array == null || array.length == 0) {
            return null;
        }
        int lowerBound = 0;
        int upperBound = array.length - 1;

        while (lowerBound <= upperBound) {
            int middleBound = lowerBound + ((upperBound - lowerBound) >> 1);
            int valueAtMiddle = array[middleBound];
            if(k < valueAtMiddle) {
                upperBound = middleBound - 1;
            } else {
                if(middleBound == array.length -1 || array[middleBound + 1] > k) {
                    return middleBound;
                }else {
                    lowerBound = middleBound + 1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,2,3,4,5,6}, 5));
        System.out.println(searchFirstEq(new int[]{1,2,3,5,5,6}, 5));
        System.out.println(searchLastEq(new int[]{1,2,3,5,5,5}, 5));
        System.out.println(searchLastLtEq(new int[]{1,2,3,3,5,5,5}, 3));
    }
}
