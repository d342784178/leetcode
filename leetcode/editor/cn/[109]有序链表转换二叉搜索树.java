//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 分治法: 要找到平衡因为是有序数组 所以其平衡树定为以中间节点跟根节点的二叉树. 因此找到中间节点,不断划分左右子树进行构造
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        //print(head);
        //找到中间节点
        ListNode middle = middle(head);
        //System.out.println("head:" + head.val + "  middle:" + middle.val);
        if (middle == head) {
            return new TreeNode(head.val);
        }

        TreeNode root = new TreeNode(middle.val);
        //构造右子树
        root.right = sortedListToBST(middle.next);
        //构造左子树
        root.left = sortedListToBST(head);
        return root;
    }

    private void print(ListNode head) {
        while (true) {
            System.out.print(head.val + ",");
            head = head.next;
            if (head == null) {
                break;
            }
        }
        System.out.println("");
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
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 263 👎 0
