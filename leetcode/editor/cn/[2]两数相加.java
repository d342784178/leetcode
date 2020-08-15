//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4572 👎 0


import java.util.*;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 腾空1位
        ListNode node = new ListNode(0);
        ListNode p = l1, q = l2, cur = node;
        int carry = 0;
        while (true) {
            // p/q可能为空
            int t = (p == null ? 0 : p.val) + (q == null ? 0 : q.val) + carry;
            cur.val = t % 10;
            carry = t / 10;

            // 如果p.next/q.next均为空,且carry==0 则break
            if ((p == null || p.next == null) && (q == null || q.next == null) && carry == 0) {
                break;
            }
            p = p!=null?p.next:null;
            q = q!=null?q.next:null;
            cur.next = new ListNode(0);
            cur = cur.next;
        }

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
