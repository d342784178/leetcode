//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路:
     * 使用当index=i时 计算当前i能走到的最远maxJ，再往前走直到index=maxJ，期间不断更新maxJ
     * 例:[2,3,1,1,4]
     * i=0时 maxJ=0+2=2
     * i=1时 maxJ=max（2，1+3）=4>=4因此return True
     *
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int maxJ = 0;
        for (int i = 0; i < nums.length && i <= maxJ; i++) {
            maxJ = Math.max(maxJ, i + nums[i]);
            if (maxJ >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//给定一个非负整数数组，你最初位于数组的第一个位置。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个位置。
//
// 示例 1:
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
//
//
// 示例 2:
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
//
// Related Topics 贪心算法 数组
// 👍 732 👎 0