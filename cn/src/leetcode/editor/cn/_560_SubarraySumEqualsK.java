//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

import sun.jvm.hotspot.debugger.LongHashMap;

import java.util.HashMap;
import java.util.Map;

public class _560_SubarraySumEqualsK{
  public static void main(String[] args) {
       Solution solution = new _560_SubarraySumEqualsK().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        // 1. Brute force
//        for(int i=0;i < nums.length; i++) {
//            for(int j=i;j < nums.length;j++) {
//                int sum=0;
//                for(int m = i; m <=j; m++) {
//                    sum+=nums[m];
//                }
//                if(sum == k) {
//                    count++;
//                }
//            }
//        }
        // 2. 去重计算
//        for(int i =0; i < nums.length; i++) {
//            int sum = 0;
//            for(int j = i; j <nums.length; j++) {
//                sum += nums[j];
//                if(sum == k) {
//                    count++;
//                }
//            }
//        }
        //前缀和求解
        //https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/dai-ni-da-tong-qian-zhui-he-cong-zui-ben-fang-fa-y/

        long prefixSum = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        for (int num : nums) {
            prefixSum += num;
            Long tmpCount = map.get(prefixSum - k);
            if (tmpCount != null) {
                count += tmpCount;
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0L) + 1);
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}