package com.laugh.leetcode;

/**
 * @author yu.gao 2020-04-13 8:27 下午
 */
public class _14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for(String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        int low = 1;
        int high = minLen;
        boolean[] flag = new boolean[high + 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if(flag[mid] || isCommonPrefix(strs, mid)) {
                low = mid + 1;
                flag[mid] = true;
            } else {
                high = mid - 1;
                flag[mid] = false;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }
    private static boolean isCommonPrefix(String[] strs, int mid) {
        String prefix = strs[0].substring(0, mid);
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
