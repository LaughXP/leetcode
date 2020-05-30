//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划


package leetcode.editor.cn;
public class _53_MaximumSubarray{
  public static void main(String[] args) {
       Solution solution = new _53_MaximumSubarray().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //dp
//        int len = nums.length;
//        if(len == 0) {
//            return 0;
//        }
//        int[] dp = new int[len];
//        dp[0] = nums[0];
//        for(int i=1; i< len; i++) {
//            if(dp[i-1] >= 0) {
//                dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
//            } else {
//                dp[i] = nums[i];
//            }
//        }
//        int res = dp[0];
//        for(int i=0; i< len; i++) {
//            res = Math.max(res, dp[i]);
//        }
        //dp compaction
        if(nums == null) {
            return 0;
        }
        int max = nums[0];
        int subMax = max;
        for(int i =1; i<nums.length; i++) {
            if(subMax >= 0) {
                subMax = Math.max(subMax + nums[i], nums[i]);
            } else {
                subMax = nums[i];
            }
            max = Math.max(max, subMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}