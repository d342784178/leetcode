import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * [5,0]
     * [5,0][7,0]
     * [5,0][7,0][6,1]
     * [5,0][7,0][6,1][7,1]
     * [5,0][7,0][5,2][6,1][7,1]
     * [5,0][7,0][5,2][6,1][4,4][7,1]
     * 插入法
     * k由小到达, h由小到大(因为k表示是排在这个人前面且身高大于或等于h的人数,所以从小的h开始插入,这样不会对已经插入的k造成印象)
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int compare = Integer.compare(o1[1], o2[1]);
                if (compare == 0) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return compare;
                }
            }
        });
        //存放结果
        ArrayList<int[]> objs = new ArrayList<>();
        //存放k为0的指针位置,防止每次插入都从头开始读
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < people.length; i++) {
            //遍历进行插入
            sdf(people[i], objs, indexMap);
            //System.out.print("index:" + indexMap + "  objs:");
            //objs.forEach(o -> System.out.print(Arrays.toString(o)));
            //System.out.println("");
        }
        return objs.toArray(new int[0][]);
    }

    /**
     * 插入法
     * @param p
     * @param objs
     */
    private void sdf(int[] p, List<int[]> objs, Map<Integer, Integer> indexMap) {
        System.out.println(Arrays.toString(p));
        int k = p[1], i = indexMap.getOrDefault(p[0], 0);
        for (; i < objs.size(); i++) {
            //获取当前i指向的people
            int[] cP = objs.get(i);
            //如果k==0,更新map中指针
            if (cP[1] == 0) {
                indexMap.put(cP[0], i);
            }
            if (p[1] <= 0) {
                //k<=0 直接插入末尾
                objs.add(p);
                return;
            } else {
                if (cP[0] < p[0] || k-- > 0) {
                    //两个条件:
                    //1. cp.h<p.h
                    //2. cp.h>=p.h&&k-->0

                    //System.out.println("跳过:" + Arrays.toString(cP) + "  k:" + k);
                    continue;
                } else {
                    //cp.h>=p.h &&k==0
                    objs.add(i, p);
                    return;
                }
            }
        }
        //objs为空,直接加到末尾
        objs.add(p);
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


import java.util.*;

//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 398 👎 0


