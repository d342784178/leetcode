import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路: 动态规划
     * 对于dp[i][j]表示由word1[i]->word2[j]的最小距离
     * 对于word1[i]->word2[j] 有3种方式
     * </br>
     * 1. 替换 dp[i][j]=dp[i-1][j-1]+1 表示对于dp[i-1][j-1],通过替换word1[i]->word2[j]即可完成转换
     * 2. 插入 dp[i][j]=dp[i][j-1]+1 表示对于dp[i][j-1],通过插入word1[i+1]使得word1[i+1]=word[j]=>word1[i]=word[j-1]即可完成转换
     * 3. 删除 dp[i][j]=dp[i-1][j]+1 表示对于dp[i-1][j],通过删除word1[i]使得word1[i-1]=word[j]即可完成转换
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return sdf(new int[word1.length()][word2.length()], word1, word1.length() - 1, word2, word2.length() - 1,
                new ArrayDeque<String>());
    }

    private int sdf(int[][] dp, String word1, int i, String word2, int j, Deque<String> stack) {
        //System.out.println(word1.substring(0, i + 1) + "," + word2.substring(0, j + 1));
        if (i < 0 || j < 0) {
            //System.out.println(Math.abs(i - j) + "," + stack);
            //i或j已经指针小于0,因此其差的绝对值即其最小距离
            return Math.abs(i - j);
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = ss(dp, word1, i, word2, j, stack, "E");
        } else {
            dp[i][j] = 1 + Math.min(Math.min(ss(dp, word1, i, word2, j, stack, "A"),
                    ss(dp, word1, i, word2, j, stack, "D")),
                    ss(dp, word1, i, word2, j, stack, "R"));
        }
        return dp[i][j];
    }

    private int ss(int[][] dp, String word1, int i, String word2, int j, Deque<String> stack, String s) {
        int res = 0;
        if (s.equals("A")) {
            stack.addLast("A");
            res = sdf(dp, word1, i, word2, j - 1, stack);
            stack.removeLast();
        } else if (s.equals("D")) {
            stack.addLast("A");
            res = sdf(dp, word1, i - 1, word2, j, stack);
            stack.removeLast();
        } else if (s.equals("R")) {
            stack.addLast("A");
            res = sdf(dp, word1, i - 1, word2, j - 1, stack);
            stack.removeLast();
        } else {
            stack.addLast("E");
            res = sdf(dp, word1, i - 1, word2, j - 1, stack);
            stack.removeLast();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划 
// 👍 978 👎 0
