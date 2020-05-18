//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表


package leetcode.editor.cn;
public class _206_ReverseLinkedList{
  public static void main(String[] args) {
       Solution solution = new _206_ReverseLinkedList().new Solution();
       ListNode head1 = new ListNode(1);
       ListNode head2 = new ListNode(2);
       ListNode head3 = new ListNode(3);
       ListNode head4 = new ListNode(4);
       ListNode head5 = new ListNode(5);
      head1.next = head2;
      head2.next = head3;
      head3.next = head4;
      head4.next = head5;
      ListNode res = solution.reverseList(head1);
      while (res != null) {
          System.out.println(res.val);
          res = res.next;
      }
  }
    public static class ListNode {
        int                                val;
        ListNode next;
        public ListNode(int x) {
            val = x;
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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
//        ListNode curr = head;
//        ListNode pre = null;
//        ListNode next = null;
//        while (curr != null) {
//            next = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = next;
//        }
//        return pre;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode removed;
        while (head.next != null) {
            //先删除当前节点的后继节点
            removed = head.next;
            head.next = head.next.next;

            //将删除节点插入到哨兵节点后面，即头插法
            removed.next = dummy.next;
            dummy.next = removed;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}