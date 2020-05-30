//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。 
//
// 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _93_RestoreIpAddresses{
  public static void main(String[] args) {
      Solution solution = new _93_RestoreIpAddresses().new Solution();
      System.out.println(solution.restoreIpAddresses("25525511135"));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
//        if(s == null || s.length() < 4 || s.length() > 12) {
//            return new ArrayList<>();
//        }
//        List<String> res = new ArrayList<>();
//        Deque<String> path = new ArrayDeque<>(4);
//        dfs(s, s.length(), 0, 0, path, res);
        int n = s.length();
        List<String> res = new ArrayList<>();
        dfs(s, n, 0, 0, "", res);
        return res;
    }

    private void dfs(String s, int n, int start, int depth, String path, List<String> res) {
        if(depth == 4) {
            res.add(path.substring(0, path.length() - 1));
            return;
        }
        int endMin = Math.max(start + 1, n - (3 - depth) * 3);
        int endMax = Math.min(start + 3, n - (3 - depth));
        for(int i = endMin; i <= endMax; i++) {
            String split = s.substring(start, i);
            int len = split.length();
            if(len > 1 && split.charAt(0) == '0') {
                break;
            }
            if(Integer.parseInt(split) <= 255) {
                dfs(s, n, i, depth + 1, path + (split + '.'), res);
            }
        }

    }

//    private void dfs(String s, int len, int start, int splitted, Deque<String> path, List<String> res) {
//        if(start == len) {
//            if(path.size() == 4) {
//                res.add(String.join(".", path));
//                return;
//            }
//        }
//        if(len - start < (4 - splitted) * 1 || len - start > 3 * (4 - splitted)) {
//            return;
//        }
//        for(int i = 0; i < 3; i++) {
//            if(start + i >= len) {
//                break;
//            }
//            //不能出现连续的0，即00不能出现
//            if(i > 0 && s.charAt(start) == '0') {
//                continue;
//            }
//            String sub = s.substring(start, start + i + 1);
//            if(Integer.parseInt(sub) <= 255) {
//                path.addLast(sub);
//                dfs(s, len, start + i + 1, splitted + 1, path, res);
//                path.removeLast();
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}