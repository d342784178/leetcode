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
    /**
     * 思路:
     * 若node1,node2,node3重复 将指针指向node3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode j     = dummy;

        do {
            boolean repeat = false;
            //如果重复指到最后一个重复结点
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
                repeat = true;
            }
            //System.out.println(head.val);
            if (!repeat) {
                //不重复,进行赋值
                //System.out.println(head.val);
                j.next = head;
                j = j.next;
            } else {
                //重复,将next指针置空 参考[1,2,2]
                j.next = null;
            }
            head = head.next;
        } while (head != null);
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 319 👎 0
