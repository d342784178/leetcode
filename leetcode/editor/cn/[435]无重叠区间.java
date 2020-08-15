//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法 
// 👍 169 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路:
     * 例[ [1,4][4,5][1,3][2,3] ]
     * 1. [1,4] 自身不重叠
     * 2. {[1,4]}&[4,5]不重叠
     * 3. {[1,4],[4,5]}&[1,3]重叠 移除[1,4]或[1,3]
     * 4.1 {[1,3],[4,5]}&[2,3] 不重叠
     * 4.2 {[1,4],[4,5]}&[2,3] 重叠 移除[1,4]或[2,3]
     * 5. 移除[1,4]
     * </br>
     * 总结:
     * 从上述例子中看到假若存在一个大区间包含多个小区间,那么就需要进行回溯,时间复杂度上升.
     * 因此为了解决这个问题采用尾区间排序,因为大区间一定排在多个小区间后面,所以可以避免该问题.参考56合并区间
     * 由于在遍历过程中只记录了当前指针下的最大尾区间,所以当出现尾区间相同的情况[[1,2][1,3][2,3][4,5]] 此时[1,3][2,3]顺序可能随机互换造成两种情况
     * - [[1,2][2,3][1,3][4,5]] 当i=2时 可以判断[2,3][1,3] 尾区间重叠,需要择一删除.假设删除[2,3],那么[1,2]&[1,3]会重叠
     * - [[1,2][1,3][2,3][4,5]] 当i=1时 可以判断[1,2][1,3] 尾区间重叠,需要择一删除.假设删除[1,2],那么[2,3]&[1,3]会重叠
     * 综合上述,在出现重叠情况时删除排序靠后的区间
     * </br>
     * 关键字:
     * 排序
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = 0, maxI = Integer.MIN_VALUE, remove = 0;
        for (; i < intervals.length; i++) {
            //System.out.println(Arrays.toString(intervals[i]));
            if (intervals[i][0] < maxI) {
                remove += 1;
                //System.out.println("[remove]" + Arrays.toString(intervals[i]));
            } else {
                maxI = intervals[i][1];
                //System.out.println(maxI);
            }
        }
        return remove;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
