package com.laugh.leetcode;


import sun.jvm.hotspot.debugger.LongHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author yu.gao 2018-05-15 下午10:19
 */
public class _1_TwoSum {
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

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(2048);
        for(int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if(map.containsKey(left)) {
                Integer j = map.get(left);
                return new int[]{j,i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSumBit(int[] nums, int target) {
        int volume =2048;       //100000000000
        int bitMode = volume-1;//011111111111
        int [] result =new int[volume];

        for (int i=0;i<nums.length;i++){
            int c = (target - nums[i]) & bitMode;
            if (result[c]!=0){
                return new int[]{result[c]-1,i};
            }
            result[nums[i] & bitMode]=i+1;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] result = twoSum(nums, 9);
        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.toString(twoSumHashMap(nums, 9)));
        System.out.println(Integer.toBinaryString(2047));
        System.out.println(Integer.toBinaryString(-100));
        System.out.println(Integer.toBinaryString(-100 & 2047));
    }
}
