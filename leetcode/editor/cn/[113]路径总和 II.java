import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(root.val);
        sdf(root, sum - root.val, stack, list);
        return list;
    }

    private void sdf(TreeNode root, int sum, ArrayDeque<Integer> stack, List<List<Integer>> list) {
        //System.out.println("sum:" + sum + " stack:" + stack);
        //如果是叶子节点 ,则判断sum==0,是则加到list. 然后跳出
        if (root.left == null && root.right == null) {
            //System.out.println(stack);
            if (sum == 0) {
                list.add(new ArrayList<>(stack));
            }
            return;
        }

        if (root.left != null) {
            stack.addLast(root.left.val);
            sdf(root.left, sum - root.left.val, stack, list);
            stack.removeLast();
        }
        if (root.right != null) {
            stack.addLast(root.right.val);
            sdf(root.right, sum - root.right.val, stack, list);
            stack.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 280 👎 0
