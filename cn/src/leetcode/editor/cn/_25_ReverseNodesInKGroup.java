//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


package leetcode.editor.cn;
public class _25_ReverseNodesInKGroup{
  public static void main(String[] args) {
       Solution solution = new _25_ReverseNodesInKGroup().new Solution();
       ListNode head1 = new ListNode(1);
       ListNode head2 = new ListNode(2);
       ListNode head3 = new ListNode(3);
       ListNode head4 = new ListNode(4);
       ListNode head5 = new ListNode(5);
      head1.next = head2;
      head2.next = head3;
      head3.next = head4;
      head4.next = head5;
      solution.reverseKGroup(head1, 2);
  }
  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;
        ListNode removed = null;
        int count = 0;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            count++;
            if(count == k - 1) {
                curr = pre.next;
                while (count > 0) {
                    removed = curr.next;
                    curr.next = curr.next.next;

                    removed.next = pre.next;
                    pre.next = removed;
                    count--;
                }
                pre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}