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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode i     = dummy;
        int      index = 0;
        while (i.next != null) {
            ListNode preI = i;
            i = i.next;
            index++;
            if (index - 1 == m - 1) {
                ListNode firstPre = new ListNode();
                ListNode lastNext = new ListNode();
                reverse(i, n - m + 1, firstPre, lastNext);

                preI.next = firstPre.next;
                i.next = lastNext.next;
                return dummy.next;
            }
        }
        return dummy.next;
    }


    /**
     *
     * @param head 头结点
     * @param n 反转深度
     * @param pre 头结点的前一节点
     * @param post 尾节点的后一节点
     * @return 反转后的尾节点
     */
    private ListNode reverse(ListNode head, int n, ListNode pre, ListNode post) {
        //跳出条件: n>head深度 则head==null跳出 ,n<=head深度,则n<=1跳出
        if (head == null || head.next == null || n <= 1) {
            if (n <= 1) {
                //遍历至尾节点,将尾节点的后一节点赋值给post
                post.next = head.next;
            }
            //遍历至尾节点,因为反转后成为头结点,因此pre.next=head
            pre.next = head;
            return head;
        }

        // 递归获取尾结点
        ListNode node = reverse(head.next, n - 1, pre, post);

        // 将尾结点与其下一结点交换
        head.next = node.next;
        node.next = head;
        // print(node);
        return head;
    }

    private void print(ListNode a) {
        int i = 0;
        while (i++ < 100) {
            System.out.print(a.val);
            a = a.next;
            if (a == null) {
                break;
            }
        }
        System.out.println("");
    }
}
//leetcode submit region end(Prohibit modification and deletion)


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
// 👍 426 👎 0
