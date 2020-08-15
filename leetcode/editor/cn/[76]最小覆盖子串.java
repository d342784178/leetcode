import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, List<Integer>> aa = aa(s);
        HashMap<Character, Integer>       bb = bb(t);
        int                               i  = 0, ii = 0, jj = s.length();
        for (; i < s.length(); ) {
            int j = i + t.length() - 1;
            //j往前走直到contain(t)
            for (; j < s.length(); ) {
                Integer less = contain(i, j, aa, bb);
                //System.out.println(less + "   " + i + "," + j + " " + s.substring(i, j + 1));
                if (less == 0) {
                    if (j - i < jj - ii) {
                        ii = i;
                        jj = j;
                        //System.out.println("contain: " + s.substring(ii, jj + 1));
                    }
                    break;
                } else {
                    j += less;
                }
            }
            if (j >= s.length()) {
                break;
            }

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
     * 优化: 参考leetcode标准答案
     * @param i
     * @param j
     * @param aa
     * @param bb
     * @return
     */
    private Integer contain(int i, int j, Map<Character, List<Integer>> aa, Map<Character, Integer> bb) {
        int less = 0;
        for (Map.Entry<Character, Integer> entry : bb.entrySet()) {
            List<Integer> integers = aa.get(entry.getKey());
            if (integers == null) {
                less += entry.getValue();
                continue;
            }
            int contains = (int) integers.stream().filter(integer -> integer >= i && integer <= j).count();
            if (contains >= entry.getValue()) {
                continue;
            } else {
                less += entry.getValue() - contains;
            }
        }
        return less;
    }

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
