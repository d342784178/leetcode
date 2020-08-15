//leetcode submit region begin(Prohibit modification and deletion)

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
     * 1. root节点在前序中必为第一个节点
     * 2. 子树长度必定相等
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {

        if (pl > pr || il > ir) {
            return null;
        }
        //System.out.println(Arrays.toString(Arrays.copyOfRange(preorder, pl, pr + 1)) + "," + Arrays.toString(Arrays
        // .copyOfRange(inorder, il, ir + 1)));
        if (pl == pr) {
            return new TreeNode(preorder[pl]);
        }
        if (il == ir) {
            return new TreeNode(inorder[il]);
        }
        //左右子树分割位置(相对位置)
        int split = 0;
        //根据root节点值在中序中找到root节点所在位置(root节点在前序中必为第一个节点)
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) {
                split = i - il;
            }
        }
        //递归构造左右子树
        //System.out.println("split:" + split);
        //System.out.println(String.format("left:%d,%d,%d,%d", pl + 1, pl + split, il, il + split - 1));
        TreeNode left = buildTree(preorder, inorder, pl + 1, pl + split, il, il + split - 1);
        //if (left != null) {
        //    System.out.println("left" + left.val);
        //}
        //System.out.println(String.format("right:%d,%d,%d,%d", pl + split + 1, pr, il + split + 1, ir));
        TreeNode right = buildTree(preorder, inorder, pl + split + 1, pr, il + split + 1, ir);
        //if (right != null) {
        //    System.out.println("right" + right.val);
        //}

        TreeNode root = new TreeNode(inorder[il + split]);
        root.left = left;
        root.right = right;
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 582 👎 0
