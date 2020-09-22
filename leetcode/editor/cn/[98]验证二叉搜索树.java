//leetcode submit region begin(Prohibit modification and deletion)

import javax.sound.midi.Soundbank;

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
     * 分治思想: 左子树<根节点,右子树>根节点.递归分治
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return asdf(root, null, null);
    }

    /**
     * 维护上下区间,往左子树遍历上区间不变,往右子树遍历下区间不变
     * @param root
     * @param lower 下区间
     * @param bigger 上区间
     * @return
     */
    private boolean asdf(TreeNode root, Integer lower, Integer bigger) {
        if (root == null) {
            return true;
        }
        System.out.println(root.val+","+lower+","+bigger);
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (bigger != null && val >= bigger) {
            return false;
        }
        boolean leftOk = false, rightOk = false;
        leftOk = asdf(root.left, lower, val);
        rightOk = asdf(root.right, val, bigger);
        return leftOk && rightOk;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 678 👎 0
