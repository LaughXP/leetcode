package com.laugh.leetcode;

import java.util.Arrays;

/**
 * @author yu.gao 2019-12-25 12:09 AM
 */
public class _26_RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i=1; i < nums.length; i++) {
            if(nums[j] != nums[i]) {
                if(i - j > 1) {
                    nums[j+1] = nums[i];
                }
                j++;
            }
        }
        return j+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
