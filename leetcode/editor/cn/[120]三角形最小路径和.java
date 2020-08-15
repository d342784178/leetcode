import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                Integer ii = triangle.get(i).get(j);
                if (i - 1 < 0) {
                    dp[i][j] = ii;
                } else if (j - 1 < 0) {
                    dp[i][j] = ii + dp[i - 1][j];
                } else if (j >= triangle.get(i - 1).size()) {
                    dp[i][j] = ii + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = ii + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        int mSum = Integer.MAX_VALUE;
        for (int i = 0; i < dp[dp.length - 1].length; i++) {
            mSum = Math.min(mSum, dp[dp.length - 1][i]);
        }
        return mSum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 543 👎 0
