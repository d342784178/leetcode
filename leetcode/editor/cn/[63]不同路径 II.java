//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int dp = dp(obstacleGrid.length - 1,obstacleGrid[0].length - 1,  obstacleGrid);
        return dp * -1;
    }

    private int dp(int m, int n, int[][] visited) {
        //防止重复
        if (visited[m][n] <= -1) {
            return visited[m][n];
        }
        if (visited[m][n] == 1) {
            return 0;
        }
        //System.out.println(String.format("m:%d,n:%d", m, n));
        //1.跳出条件
        if (m == 0 && n == 0) {
            return -1;
        }
        //2.向上或向左的拆解
        int sum = 0;
        if (m >= 1 && visited[m - 1][n] != 1) {
            visited[m - 1][n] = dp(m - 1, n, visited);
            sum += visited[m - 1][n];
        }
        if (n >= 1 && visited[m][n - 1] != 1) {
            visited[m][n - 1] = dp(m, n - 1, visited);
            sum += visited[m][n - 1];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 378 👎 0
