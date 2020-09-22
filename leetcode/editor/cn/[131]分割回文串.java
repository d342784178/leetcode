import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp+回溯:
     * 1. 先通过dp找到所有可能回文子串
     * 2. 再通过回溯在dp数组中找到所有能串成完整字符串的子串集合
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        //先通过dp算出所有回文串便于判断
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = true;
                } else {
                    boolean pre = j + 1 > i - 1 || dp[j + 1][i - 1];
                    dp[j][i] = pre && s.charAt(j) == s.charAt(i);
                }
            }
        }
        //1.再通过回溯在dp数组中找到所有能串成完整字符串的子串集合
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        ArrayList<List<String>> list = new ArrayList<>();
        //已知回文串的dp数组,根据[j,i]首尾相连找到可以组成完整字符串的子串
        sdf(list, new ArrayDeque<>(), dp, s.length() - 1, s);
        return list;
    }

    /**
     * 回溯,2个优化点
     * 1. 备忘录
     * 2. 字符串截取
     * @param list
     * @param stack
     * @param dp
     * @param index
     * @param s
     */
    private void sdf(List<List<String>> list, Deque<String> stack, boolean[][] dp, int index, String s) {
        //System.out.println(String.format("index:%d,stack:%s", index, stack));
        if (index < 0) {
            list.add(new ArrayList<>(stack));
            return;
        }
        for (int j = 0; j < dp[index].length; j++) {
            if (dp[j][index]) {
                //System.out.println(String.format("index:%d,j:%d,str:%s", index, j, s.substring(j, index + 1)));
                stack.addFirst(s.substring(j, index + 1));
                sdf(list, stack, dp, j - 1, s);
                stack.removeFirst();
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 327 👎 0
