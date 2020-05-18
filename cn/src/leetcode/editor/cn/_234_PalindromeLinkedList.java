//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;
public class _234_PalindromeLinkedList{
  public static void main(String[] args) {
       Solution solution = new _234_PalindromeLinkedList().new Solution();
       ListNode head = new ListNode(1);
       ListNode second = new ListNode(2);
       head.next = second;
      System.out.println(solution.isPalindrome(head));
  }

  public static class ListNode {
        int      val;
        ListNode next;
        public ListNode(int x) {
            val = x;
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
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode headReverse = reverse(findMiddle(head).next);
        while (headReverse != null) {
            if(head.val != headReverse.val) {
                return false;
            }
            head = head.next;
            headReverse = headReverse.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}