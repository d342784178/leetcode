//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //归并O(nlogn)=分治O(nlogn)+合并两个链表O(1)
        ListNode right = middle(head);
        if (right == head) {
            return right;
        }
        ListNode left = head;
        left = sortList(left);
        right = sortList(right);

        ListNode listNode = mergeTwoLists(left, right);
        //print(listNode);
        return listNode;
    }

    private ListNode middle(ListNode head) {
        ListNode pre  = new ListNode();
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
            //System.out.println("slow:" + slow.val + "  pre:" + pre.val + "  post:" + post.val);
        }
        pre.next = null;
        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr   = sentry;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }

    private void print(ListNode node) {
        while (true) {
            System.out.print(node.val + ",");
            node = node.next;
            if (node == null) {
                break;
            }
        }
        System.out.println("");
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 648 👎 0
