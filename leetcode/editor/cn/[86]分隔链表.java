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
     * 有点类似快排. 维护两个指针分别指向小于x的和大于等于x的
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode i = new ListNode(), ii = i;
        ListNode j = new ListNode(), jj = j;
        do {
            if (head.val < x) {
                ii.next = head;
                ii = ii.next;
            } else {
                jj.next = head;
                jj = jj.next;
            }
            head = head.next;
        }
        while (head != null);

        ii.next = j.next;
        jj.next = null;
        return i.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 224 👎 0
