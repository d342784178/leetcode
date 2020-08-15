//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组 
// 👍 493 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        //排序: 根据右侧排序
        List<int[]> collect = Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]) * -1;
            }
        }).collect(Collectors.toList());
        //找到重叠区间: 从大往下遍历,判断一个大区间的左侧是否<=小区间的右侧

        ArrayList<int[]> objects  = new ArrayList<>();
        int[]            interval = null;
        collect.add(null);
        for (int[] ints : collect) {
            if (interval == null) {
                interval = ints;
                continue;
            }
            if (ints == null) {
                objects.add(interval);
                interval = null;
                continue;
            }
            //System.out.println("[=]"+Arrays.toString(interval) + "," + Arrays.toString(ints));
            if (ints[1] >= interval[0]) {
                interval[0] = Math.min(ints[0], interval[0]);
            } else {
                objects.add(interval);
                //System.out.println("[+]"+Arrays.toString(interval));
                interval = ints;
            }
        }


        return objects.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
