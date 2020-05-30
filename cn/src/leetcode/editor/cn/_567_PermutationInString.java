//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class _567_PermutationInString{
  public static void main(String[] args) {
       Solution solution = new _567_PermutationInString().new Solution();
       solution.checkInclusion("abc", "eidbadcoo");
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//        Map<Character, Integer> map = new HashMap<>(26);
//        for(char c : s1.toCharArray()) {
//            map.compute(c, (k,v) -> v == null ? 1 : v+1);
//        }
//        int l = 0,r = 0;
//        while (r < s2.length()) {
//            char c = s2.charAt(r++);
//            map.compute(c, (k,v) -> v == null ? -1 : v-1);
//            while (l < r && map.getOrDefault(c, -1) < 0) {
//                map.compute(s2.charAt(l), (k,v) -> v == null ? 1 : v+1);
//                l++;
//            }
//            if(r - l == s1.length()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean checkInclusion(String s1, String s2) {
//        int len1 = s1.length(), len2 = s2.length();
//        if (len1 > len2) return false;
//        int[] ch_count1 = new int[26], ch_count2 = new int[26];
//        for (int i = 0; i < len1; ++i) {
//            ++ch_count1[s1.charAt(i) - 'a'];
//            ++ch_count2[s2.charAt(i) - 'a'];
//        }
//        for (int i = len1; i < len2; ++i) {
//            if (isEqual(ch_count1, ch_count2)) return true;
//            --ch_count2[s2.charAt(i - len1) - 'a'];
//            ++ch_count2[s2.charAt(i) - 'a'];
//        }
//        return isEqual(ch_count1, ch_count2);
//    }
//
//      private boolean isEqual(int[] ch_count1, int[] ch_count2) {
//          for (int i = 0; i < 26; ++i)
//              if (ch_count1[i] != ch_count2[i])
//                  return false;
//          return true;
//      }
public boolean checkInclusion(String s1, String s2) {
    char [] arrs=s2.toCharArray();
    char [] arrp=s1.toCharArray();
    int right=0,left=0;
    int [] std=new int [26];
    int [] window=new int[26];
    int lenp=arrp.length;
    for(char i:arrp){
        ++std[i-'a'];
    }
    while(right<arrs.length){
        char ch=arrs[right];
        ++right;
        ++window[ch-'a'];
        while (window[ch-'a']>std[ch-'a']){
            --window[arrs[left]-'a'];
            ++left;
        }
        if(right-left==lenp){
            return true;
        }
    }
    return false;
}
}
//leetcode submit region end(Prohibit modification and deletion)

}