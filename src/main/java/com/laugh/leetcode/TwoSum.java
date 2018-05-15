package com.laugh.leetcode;


import java.util.Arrays;

/**
 * @author yu.gao 2018-05-15 下午10:19
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j ++) {
                if(i == j) {
                    continue;
                }
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));
    }
}
