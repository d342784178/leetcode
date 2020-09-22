//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路:
     * 使用贪心算法
     * 例:[2,3,1,1,4]
     * i=0时 [2,3,1,1,4]=[3,1,1,4]=[1,1,4]
     * - 2[3,1,1,4] i=1 2[3,1,1,4]=2,3[1,1,4]=2,3,1[1,4]=[4]  跳出
     * - 2,3[1,1,4] i=2 参考2[3,1,1,4]
     *
     * 从上面可以看到当指针指向i时,我们需要去尝试在maxI(指针i能走到的最远下标)范围内的所有位置.
     * 因此维护遍历i不断更新maxI,直到遍历结束||maxI>=nums.length
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        //i指向nums,maxI记录当前i可以走到的最远下标
        int i = 0, maxI =0+ nums[0];
        for (; i <= maxI && i < nums.length; i++) {
            maxI = Math.max(maxI, i + nums[i]);
            //System.out.println(String.format("i:%d,maxI:%d", i, maxI));
        }
        return maxI >= (nums.length-1);

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