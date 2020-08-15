//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 思路: 两次二分法查找,一次左区间,一次右区间.根据index属于左区间还是右区间来区分.
        // 异常:
        // 1. nums为空
        // 2. 下标越界,目标值可能不存在,需要考虑大于最大值和小于最小值的情况
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l, r;
        {// 左区间
            int ll = 0, rr = nums.length - 1;
            while (ll <= rr) {
                int index = (ll + rr) / 2;
                //System.out.println(ll + "," + rr);
                int t = nums[index];
                if (t == target) {
                    rr = index - 1;
                } if (t < target) {
                    ll = index + 1;
                } else if (t > target) {
                    rr = index - 1;
                }
            }
            //target可能不存在 当target>nums[nums.length-1]时 ll> nums.length-1
            l = ll > nums.length - 1 || nums[ll] != target ? -1 : ll;
            // System.out.println(l);
        }
        // System.out.println("");
        {// 右区间
            int ll = 0, rr = nums.length - 1;
            while (ll <= rr) {
                int index = (ll + rr) / 2;
                //System.out.println(ll + "," + rr);
                int t = nums[index];
                if (t == target) {
                    ll = index + 1;
                } if (t < target) {
                    ll = index + 1;
                } else if (t > target) {
                    rr = index - 1;
                }
            }
            //target可能不存在 当target<nums[0]时 ll<0
            r = rr < 0 || nums[rr] != target ? -1 : rr;
            // System.out.println(r);
        }
        return new int[]{l, r};
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 509 👎 0
