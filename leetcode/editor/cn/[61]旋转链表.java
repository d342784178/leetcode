//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//
//
// 示例 2:
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
// Related Topics 链表 双指针
// 👍 292 👎 0


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
     * 所谓旋转就是,k后的结点放到头上->倒数k-nl个结点
     * 关键点:
     * k-nl结点,头结点
     * 注意: k可能超过链表长度
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        //指向当前遍历结点
        ListNode current   = head;
        //指向断开结点的前一个结点,用于将其next置空
        ListNode targetPre = null;
        //尾结点,需要将其next=head
        ListNode last      = null;
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        int length = 1;
        while (true) {
            //当k走到0时 targetPre开始走
            k -= 1;
            if (k == -1) {
                targetPre = head;
                //System.out.println("[targetPre catch]" + targetPre.val);
            }
            //k可能超过链表长度,所以循环往下遍历
            if (current.next != null) {
                //未超出链表长度
                length += 1;
                current = current.next;
                if (targetPre != null) {
                    targetPre = targetPre.next;
                }
            } else {
                //超出链表长度
                last = current;
                //System.out.println("[last]" + last.val);
                //System.out.println("[length]" + length);
                //根据链表长度对k做减法,减少不必要的循环
                k = k % length;
                if (k == 0) {
                    return head;
                }
                current = head;
                if (targetPre != null) {
                    //当走到末尾时,并且targetPre也不为空则跳出
                    //System.out.println("[targetPre]" + targetPre.val);
                    break;
                }
            }
        }
        last.next = head;
        ListNode target = targetPre.next;
        targetPre.next = null;
        return target;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
