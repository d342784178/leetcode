//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp  = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                dp[i][0] = nums[i];
                dp[i][1] = nums[i];
            } else {
                if (nums[i] >= 0) {
                    dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                    dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
                } else {
                    dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                    dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
                }
            }
        }
        // 只关心最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 674 👎 0
