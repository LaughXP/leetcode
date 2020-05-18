//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


package leetcode.editor.cn;
public class _92_ReverseLinkedListIi{
  public static void main(String[] args) {
       Solution solution = new _92_ReverseLinkedListIi().new Solution();
       ListNode head1 = new ListNode(1);
       ListNode head2 = new ListNode(2);
       ListNode head3 = new ListNode(3);
       ListNode head4 = new ListNode(4);
       ListNode head5 = new ListNode(5);
       head1.next = head2;
       head2.next = head3;
       head3.next = head4;
       head4.next = head5;
       ListNode res = solution.reverseBetween(head1, 2, 4);
       while (res != null) {
           System.out.println(res.val);
           res = res.next;
       }
  }
    static class ListNode {

        int                              val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode tail = dumy;
        ListNode curr = head;
        while (m>1) {
            tail = tail.next;
            curr = curr.next;
            m--;
            n--;
        }
        int left = n - m;
        ListNode removed;
        while (left-- > 0) {
            //先删除当前节点的后继节点
            removed = curr.next;
            curr.next = curr.next.next;
            //将删除节点插入到tail节点后面，即头插法
            removed.next = tail.next;
            tail.next = removed;
        }
        return dumy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}