package com.laugh.leetcode;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author yu.gao 2019-12-25 10:59 PM
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int j = 0; j < prices.length - 1; j ++) {
            int profit = 0;
            int tmpJ = j;
            for(int i=j; i < prices.length; i++) {
                int tmpProfit = prices[i] - prices[tmpJ];
                if(tmpProfit > 0) {
                    profit += tmpProfit;
                    i++;
                    tmpJ = i;
                }
            }
            if(maxProfit < profit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));

        System.out.println(URLEncoder.encode("url", "utf-8"));
        System.out.println(URLEncoder.encode("http://www.baidu.com?url=傻逼", "utf-8"));
        System.out.println(URLDecoder.decode("http%3A%2F%2Fwww.baidu.com%3Furl%3D%E5%82%BB%E9%80%BC", "utf-8"));
        System.out.println(URLEncoder.encode("http://www.baidu.com?url=http://www.baidu.com", "utf-8"));
    }
}
