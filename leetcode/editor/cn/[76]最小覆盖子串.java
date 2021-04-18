import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //思路: 1. 收集s中元素所在位置,统计t中各元素个数
        //2.滑动窗口[i,j]遍历s,每次指针前进都计算[i,j]还欠缺多少元素
        HashMap<Character, List<Integer>> aa = aa(s);
        HashMap<Character, Integer>       bb = bb(t);
        //i:i指针 ii:ii指针 jj:长度
        int i = 0, ii = 0, jj = s.length();
        for (; i < s.length(); ) {
            int j = i + t.length() - 1;
            //j往前走直到contain(t)
            for (; j < s.length(); ) {
                Integer less = contain(i, j, aa, bb);
                //System.out.println(less + "   " + i + "," + j + " " + s.substring(i, j + 1));
                if (less == 0) {
                    //[i,j]中包含t中所有元素
                    if (j - i < jj - ii) {
                        //当前窗口小于上一最小窗口,更新窗口
                        ii = i;
                        jj = j;
                        //System.out.println("contain: " + s.substring(ii, jj + 1));
                    }
                    break;
                } else {
                    //当前[i,j]还欠缺t中less个元素,因此窗口直接扩大less
                    j += less;
                }
            }

            if (j >= s.length()) {
                //s不包含t中所有元素,直接跳出
                break;
            }
            //i往前缩小敞口
            while (i > j - t.length()) {
                //固定j,i往前走缩小范围
                Integer less = contain(i, j, aa, bb);
                //System.out.println(less + "   " + i + "," + j + " " + s.substring(i, j + 1));
                if (less == 0) {
                    if (j - i < jj - ii) {
                        ii = i;
                        jj = j;
                        //System.out.println("contain: " + s.substring(ii, jj + 1));
                    }
                    i++;
                } else {
                    //一旦t往前导致less>0,则直接跳出
                    break;
                }
            }
            i++;
        }
        if ((jj - ii) >= s.length()) {
            return "";
        }
        return s.substring(ii, jj + 1);

    }


    /**
     * TODO 优化: 参考leetcode标准答案
     * @param i
     * @param j
     * @param aa
     * @param bb
     * @return [i,j]还欠缺多少bb元素个数
     */
    private Integer contain(int i, int j, Map<Character, List<Integer>> aa, Map<Character, Integer> bb) {
        int less = 0;
        for (Map.Entry<Character, Integer> entry : bb.entrySet()) {
            List<Integer> integers = aa.get(entry.getKey());
            //bb元素在aa中是否存在
            if (integers == null) {
                //不存在,则将bb次数加到less中
                less += entry.getValue();
                continue;
            }
            //存在,统计在[i,j]中存在多少该元素
            int contains = (int) integers.stream().filter(integer -> integer >= i && integer <= j).count();
            if (contains >= entry.getValue()) {
                //数量大于bb中该元素所需的数量,则continue
                continue;
            } else {
                //否则,将欠缺数量加到less中
                less += entry.getValue() - contains;
            }
        }
        return less;
    }

    /**
     * 以key:字符维度整合index
     */
    private HashMap<Character, List<Integer>> aa(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char          key       = s.charAt(i);
            List<Integer> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(i);
            map.put(key, orDefault);
        }

        return map;
    }

    /**
     * 以key:字符纬度统计出现次数
     */
    private HashMap<Character, Integer> bb(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char    key       = s.charAt(i);
            Integer orDefault = map.getOrDefault(key, 0);
            map.put(key, orDefault + 1);
        }

        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 648 👎 0
