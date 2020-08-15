import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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
    /**
     * 思路:
     * 额外使用list存放下一层结点,便于做逆序处理. 需要注意当当前层本身为逆序遍历时,加入左右结点的顺序
     *    1
     *   / \
     *  2  3
     * /  \   /  \
     *4   5    6   7
     *第二层为逆序遍历 2->3,如果先左后右加入子节点的话=>6,7,4,5 不好处理. 因此先右后左=>7,6,5,4,然后直接逆序处理
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        boolean reverse = false;
        while (!queue.isEmpty()) {
            //当前层的结点个数
            int           n     = queue.size();
            List<Integer> level = new ArrayList<>();
            //一次遍历完当前层的所有结点
            ArrayList<TreeNode> list = new ArrayList<>(n*2);
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeFirst();
                level.add(node.val);
                if (!reverse) {
                    //当为正序遍历时,先左后右
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                } else {
                    //当为逆序遍历时,先右后左,配合下面进行reverse
                    if (node.right != null) {
                        list.add(node.right);
                    }
                    if (node.left != null) {
                        list.add(node.left);
                    }

                }
            }
            //list.forEach(treeNode -> System.out.print(treeNode.val));
            //System.out.println("");
            Collections.reverse(list);
            //list.forEach(treeNode -> System.out.print(treeNode.val));
            //System.out.println("");
            queue.addAll(list);
            reverse = !reverse;
            res.add(level);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 224 👎 0
