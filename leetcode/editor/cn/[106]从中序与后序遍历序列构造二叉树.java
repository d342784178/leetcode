//leetcode submit region begin(Prohibit modification and deletion)

import javax.sound.midi.Soundbank;
import java.util.Arrays;

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
     * 1. root节点在后序中必为最后一个节点
     * 2. 子树长度必定相等
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int pl, int pr, int il, int ir) {

        if (pl > pr || il > ir) {
            return null;
        }
        //System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, pl, pr + 1)) + "," + Arrays.toString(Arrays
        //        .copyOfRange(postorder, il, ir + 1)));
        if (pl == pr) {
            return new TreeNode(inorder[pl]);
        }
        if (il == ir) {
            return new TreeNode(postorder[il]);
        }
        //左右子树分割位置(相对位置)
        int split = 0;
        //根据root节点值在中序中找到root节点所在位置(root节点在前序中必为第一个节点)
        for (int i = pl; i <= pr; i++) {
            if (inorder[i] == postorder[ir]) {
                split = i - pl;
            }
        }
        //递归构造左右子树
        //System.out.println("split:" + split);
        //System.out.println(String.format("left:%d,%d,%d,%d", pl, pl + split - 1, il, il + split - 1));
        TreeNode left = buildTree(inorder, postorder, pl, pl + split - 1, il, il + split - 1);
        //System.out.println("left:" + (left == null ? "null" : left.val));
        //System.out.println(String.format("right:%d,%d,%d,%d", pl + split + 1, pr, il + split, ir - 1));
        TreeNode right = buildTree(inorder, postorder, pl + split + 1, pr, il + split, ir - 1);
        //System.out.println("right:" + (right == null ? "null" : right.val));

        TreeNode root = new TreeNode(inorder[pl + split]);
        root.left = left;
        root.right = right;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 245 👎 0
