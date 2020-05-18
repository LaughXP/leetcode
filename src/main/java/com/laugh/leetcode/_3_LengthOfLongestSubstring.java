package com.laugh.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yu.gao 2020-04-11 10:59 下午
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_LengthOfLongestSubstring {

    public static int _force_lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int length = s.length();
        int ans = 0;
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j <= length; j ++) {
                if(allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for(int k = start; k < end; k++) {
            Character ch = s.charAt(k);
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 滑动窗口
     * 小白刚开始刷力扣，其实刷了三题，发现一个规律，最初的算法思想很多都是来自遍历过程。
     * 也就是所谓的暴力算法，但是由于哈希和一些高级数据结构的操作，实现了查询时间复杂度为常数的方法，进而衍生出优化方法
     * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
     */
    public static int lengthOfLongestSubstring_sliding_window(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
//        Set<Character> set = new HashSet<>();
        int[] array = new int[256];
        while (j < s.length()) {
//            if(!set.contains(s.charAt(j))) {
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j -i);
//            } else {
//                set.remove(s.charAt(i++));
//            }

            if(array[s.charAt(j)] == 0) {
                array[s.charAt(j++)] = 1;
                ans = Math.max(ans, j - i);
            } else {
                array[s.charAt(i++)] = 0;
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_sliding_window2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int i = 1;
        int j = 1;
        int ans = 0;
        int[] array = new int[256];
        while (j < s.length() + 1) {
            if(array[s.charAt(j-1)] > 0) {
                i = Math.max(i, array[s.charAt(j-1)]);
            }
            ans = Math.max(ans, j - i + 1);
            array[s.charAt(j-1)] = ++j;
//            i = Math.max(i, array[s.charAt(j)]);
//            ans = Math.max(ans, j - i + 1);
//            array[s.charAt(j)] = ++j;
        }
//        Map<Character, Integer> map = new HashMap<>();
//        while (j < s.length()) {
//            if(map.containsKey(s.charAt(j))) {
//                i = Math.max(i, map.get(s.charAt(j)) + 1);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j++);
//        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("" + _force_lengthOfLongestSubstring1("abcabcbb"));
        System.out.println("" + _force_lengthOfLongestSubstring1("bbbbb"));
        System.out.println("" + _force_lengthOfLongestSubstring1("pwwkew"));
        System.out.println("" + _force_lengthOfLongestSubstring1("abcbcabcadef"));
        System.out.println("" + _force_lengthOfLongestSubstring1("abc"));
        System.out.println("=================");
        System.out.println("" + lengthOfLongestSubstring_sliding_window("abcabcbb"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window("bbbbb"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window("pwwkew"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window("abcbcabcadef"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window("abc"));
        System.out.println("=================");
        System.out.println("" + lengthOfLongestSubstring_sliding_window2("abcabcbb"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window2("bbbbb"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window2("pwwkew"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window2("abcbcabcadef"));
        System.out.println("" + lengthOfLongestSubstring_sliding_window2("abc"));
    }
}
