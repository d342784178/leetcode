//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 598 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路: 动态规划
     * 因为机器人只能向下或向右走 因此对于到达m,n点的方法个数
     * f[m][n]=f[m-1][n]+f[m][n-1]逐步展开
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //记录到达每个点的方法数,防止重复计算
        int[][] visited = new int[m][n];
        return dp(m - 1, n - 1, visited);
    }

    private int dp(int m, int n, int[][] visited) {
        //防止重复
        if (visited[m][n] >= 1) {
            return visited[m][n];
        }
        //System.out.println(String.format("m:%d,n:%d", m, n));
        //1.跳出条件
        if (m == 0 && n == 0) {
            return 1;
        }
        //2.向上或向左的拆解
        int sum = 0;
        if (m >= 1) {
            visited[m - 1][n] = dp(m - 1, n, visited);
            sum += visited[m - 1][n];
        }
        if (n >= 1) {
            visited[m][n - 1] = dp(m, n - 1, visited);
            sum += visited[m][n - 1];
        }
        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
