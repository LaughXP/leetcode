package com.laugh.dp;

/**
 * @author yu.gao 2020-01-07 11:20 PM
 */
public class _5_最长回文子串 {

    private boolean isPalindromic(String s) {
        int len = s.length();
        for(int i = 0; i< len / 2; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindromeForce(String s) {
        String ans = "";
        int max = 0;
        int length = s.length();
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j <= length; j++) {
                String test = s.substring(i, j);
                if(isPalindromic(test) && test.length() > max) {
                    max = test.length();
                    ans = test;
                }
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        Boolean[][] p = new Boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for(int len = 1; len <= length; len++) {
            for(int start = 0; start < length; start++) {
                int end = start + len - 1;
                if(end >= length) {
                    break;
                }
                p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if(p[start][end] && len > maxLen) {
                    maxLen = len;
                    maxPal = s.substring(start, end + 1);
                }
            }
        }
        return maxPal;
    }

    public static void main(String[] args) {
        _5_最长回文子串 test = new _5_最长回文子串();
        System.out.println(test.longestPalindrome("sababad"));
        System.out.println(test.longestPalindrome("cxbbyc"));
        System.out.println(test.longestPalindrome("cbc"));
        System.out.println(test.longestPalindrome("fb"));
    }
}
