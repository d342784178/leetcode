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
    public ListNode swapPairs(ListNode head) {
        return swap(head, 2);
    }

    private ListNode swap(ListNode head, int n) {
        //头结点=第一次翻转的头结点
        ListNode first = null;
        ListNode dummy = new ListNode();
        while (head != null) {
            // lastNext.next指向下个子链表的头结点
            ListNode postPre = new ListNode();
            // 返回当前子链表的尾结点
            reverse2(head, n, dummy, postPre);
            // 头结点为空,进行赋值
            if (first == null) {
                first = dummy.next;
            }
            //将head结点作为下一子链路的前一结点
            dummy = head;
            // 将head赋值为下一子链表的头结点
            head = postPre.next;
        }
        // 返回头结点
        return first;
    }


    /**
     * 非递归翻转
     * @param head    当前指针
     * @param n       翻转个数
     * @param dummy   dummy.next=翻转后的头节点
     * @param postPre postPre.next=尾节点.next
     */
    private void reverse2(ListNode head, int n, ListNode dummy, ListNode postPre) {
        ListNode pre = null;
        while (n-- > 0 && head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        dummy.next = pre;
        postPre.next = head;
    }

    /**
     * 递归翻转
     * @param head    当前指针
     * @param n       翻转个数
     * @param dummy   dummy.next=翻转后的头节点
     * @param postPre postPre.next=尾节点.next
     */
    private ListNode reverse(ListNode head, int n, ListNode dummy, ListNode postPre) {
        if (head == null || head.next == null || n <= 1) {
            if (n <= 1) {
                postPre.next = head.next;
            }
            dummy.next = head;
            return head;
        }

        // 递归获取尾结点
        ListNode node = reverse(head.next, n - 1, dummy, postPre);

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


//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 545 👎 0
