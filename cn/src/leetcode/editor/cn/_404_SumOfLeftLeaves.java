//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树


package leetcode.editor.cn;
public class _404_SumOfLeftLeaves{
  public static void main(String[] args) {
       Solution solution = new _404_SumOfLeftLeaves().new Solution();
  }
  public class TreeNode {

      int      val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}