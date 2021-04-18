//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1254 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> lists   = new ArrayList<>();
        List<Integer>            collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        sdf(lists, new ArrayDeque<>(), collect, 0, nums.length);
        return lists;
    }

    private void sdf(List<List<Integer>> result, Deque<Integer> path, List<Integer> nums, int depth, int length) {
        if (depth == length) {
            System.out.println("[o]" + path);
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer integer = nums.get(i);
            path.addLast(integer);
            ArrayList<Integer> tNums = new ArrayList<>(nums);
            tNums.remove(i);
            sdf(result, path, tNums, depth + 1, length);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
