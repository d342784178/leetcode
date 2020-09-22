import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路:
     * 重复回溯二叉树:
     *             -
     *         -      1
     *     -    2    -     2
     * -    2  - 2  - 2   - 2
     * 可以看到存在-,-,-,2和-,-,2,-, -,1,-,2和-,1,2,-重复
     * 不重复回溯二叉树:
     *             -
     *         -      1
     *     -    2    -     2
     * -    -  - 2  - -   -  2
     * 根据上述不重复回溯树,可以看出当出现重复数时.即是在首次出现重复数节点衍生出重复子节点
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> objects = new ArrayList<>();
        sdf(nums, 0, objects, new ArrayDeque<>());
        return objects;
    }

    private void sdf(int[] nums, int i, List<List<Integer>> res, Deque<Integer> stack) {
        //System.out.println(i + ":" + stack);
        if (i >= nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }

        //计算重复长度
        int add = 1;
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            //System.out.println("++");
            add += 1;
            i += 1;
        }
        //System.out.println(i + "," + add);
        //不使用nums[i]
        sdf(nums, i + 1, res, stack);
        //根据思路中当nums[i]出现重复时,在nums[i]节点拼接子节点
        for (int j = 0; j < add; j++) {
            for (int jj = 0; jj <= j; jj++) {
                stack.addLast(nums[i]);
            }
            sdf(nums, i + 1, res, stack);
            for (int jj = 0; jj <= j; jj++) {
                stack.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 270 👎 0
