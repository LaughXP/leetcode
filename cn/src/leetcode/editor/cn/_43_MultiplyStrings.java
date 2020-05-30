//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class _43_MultiplyStrings{
  public static void main(String[] args) {
       Solution solution = new _43_MultiplyStrings().new Solution();
       solution.multiply("2", "3");
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        if(n1 < 0 || n2 < 0) {
            return "";
        }
        int[] mul = new int[n1 + n2 + 2];
        for(int i = n1; i >= 0; --i) {
            for(int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                bitmul += mul[i + j + 1];

                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }

//        return Arrays.stream(mul).skip(mul[0] == 0 ? 1 : 0).boxed().map(String::valueOf).reduce("", (a, b)-> a + b);
        StringBuilder sb = new StringBuilder();
        int i = mul[0] == 0 ? 1 : 0;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}