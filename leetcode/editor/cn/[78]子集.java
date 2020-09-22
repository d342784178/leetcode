import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] ints) {
        int                 nCnt    = ints.length;//3
        int                 nBit    = 1 << nCnt;//8
        List<List<Integer>> objects = new ArrayList<>();
        for (int i = 1; i <= nBit; i++) {//1~8
            ArrayList<Integer> aa = new ArrayList<>();
            for (int j = 0; j < nCnt; j++) {//通过位运算  取出二进制位对应的下标
                //i==8时
                //001&111 010&111 001&111
                if ((1 << j & i) != 0) {
                    aa.add(ints[j]);
                }
            }
            objects.add(aa);
        }
        return objects;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 659 👎 0
