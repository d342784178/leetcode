//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    /**
     * 将左子树移到右子树,将原右子树接到新右子树的右叶子节点
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        if (root.left != null) {
            TreeNode right = root.right;
            TreeNode left  = root.left;
            //将左子树移到右子树
            root.right = left;
            //找到右子树的最右叶子节点
            while (left.right != null) {
                left = left.right;
            }
            //将原右子树接到最右叶子节点的右子树
            left.right = right;
            root.left = null;
        }
        //levelOrderPrint(root);
    }


    public void levelOrderPrint(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            //当前层的结点个数
            int           n     = queue.size();
            List<Integer> level = new ArrayList<>();
            //一次遍历完当前层的所有结点
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        for (List<Integer> re : res) {
            System.out.println(re);
        }
        System.out.println("======");
    }

}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 428 👎 0
