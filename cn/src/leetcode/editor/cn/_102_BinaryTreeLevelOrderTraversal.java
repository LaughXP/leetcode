//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package leetcode.editor.cn;

import java.util.*;

public class _102_BinaryTreeLevelOrderTraversal{
  public static void main(String[] args) {
       Solution solution = new _102_BinaryTreeLevelOrderTraversal().new Solution();
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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
//        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        queue.offer(dummy);
//        List<Integer> list = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            TreeNode curr = queue.poll();
//            if(curr == dummy) {
//                res.add(list);
//                list = new ArrayList<>();
//                if(!queue.isEmpty()) {
//                    queue.offer(dummy);
//                }
//            } else {
//                list.add(curr.val);
//                if(curr.left != null) {
//                    queue.offer(curr.left);
//                }
//                if(curr.right != null) {
//                    queue.offer(curr.right);
//                }
//            }
//        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}