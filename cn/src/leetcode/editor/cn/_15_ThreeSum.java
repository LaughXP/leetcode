//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_ThreeSum{
  public static void main(String[] args) {
       Solution solution = new _15_ThreeSum().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        if(nums == null || nums.length < 3) {
            return all;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return all;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int curr = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r && nums[r]>=0) {
                int tmp = curr + nums[l] + nums[r];
                if(tmp == 0) {
                    all.add(Arrays.asList(curr, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else {
                    if(tmp < 0) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return all;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}