//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        return getAns(1, n, dp);
    }

    private int getAns(int start, int end, int[][] dp) {

        //此时没有数字，将 null 加入结果中
        if (start > end) {
            return 1;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            return 1;
        }
        if (dp[start][end] > 0) {
            return dp[start][end];
        }
        int ans = 0;
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            int leftTrees = getAns(start, i - 1, dp);
            //得到所有可能的右子树
            int rightTrees = getAns(i + 1, end, dp);
            //左子树右子树两两组合
            ans += leftTrees * rightTrees;
        }
        dp[start][end] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 719 👎 0
