//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


package leetcode.editor.cn;
public class _152_MaximumProductSubarray{
  public static void main(String[] args) {
       Solution solution = new _152_MaximumProductSubarray().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
//        int result = Integer.MIN_VALUE;
//        for(int i = 0; i< nums.length; i++) {
//            int tmp = 1;
//            for(int j =0; j< nums.length;j++) {
//                if(i == j) {
//                    tmp = nums[j];
//                }else {
//                    tmp *= nums[j];
//                }
//                if(tmp > result) {
//                    result = tmp;
//                }
//            }
//        }
        int len = nums.length;
        if(len == 0) {
            return 0;
        }

        // dp[i][0]: 以num[i]结尾的连续子数组的最小值
        // dp[i][1]: 以num[i]结束的连续子数组的最大值
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = dp[0][1];
        for(int i = 1; i < len; i++) {
            if(nums[i] > 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i-1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i-1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i-1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i-1][0]);
            }
            if(dp[i][1] > res) {
                res = dp[i][1];
            }
        }
        // 只关心最大值，需要遍历
//        int res = dp[0][1];
//        for(int i=1; i<len; i++) {
//            res = Math.max(res, dp[i][1]);
//        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}