package com.laugh.dp;

import java.util.Arrays;

/**
 * @author yu.gao 2019-12-31 12:25 AM
 */
public class MaxCutRod {

    private static int bottomUpCut(int p[], int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int max = -1;
            for(int j = 1; j <= i; j++) {
                System.out.println(i +","+ j + "," + max + "," + p[j-1] + "," + dp[i - j]);
                if(max < p[j-1] + dp[i - j]) {
                    max = p[j-1] + dp[i - j];
                }
            }
            System.out.println(Arrays.toString(dp) + " | " + max);
            dp[i] = max;
            System.out.println(Arrays.toString(dp) + " | " + max);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(bottomUpCut(new int[]{1,5,8,9,10,17,17,20,24,30}, 4));
    }
}
