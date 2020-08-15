import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 48) {
                //连续两个0
                if (i + 1 >= s.length() || dp[i + 1] > 0) {
                    continue;
                } else {
                    System.out.println("return");
                    return 0;
                }
            }
            if (dp[i + 1] == 0 && Integer.valueOf(s.substring(i, i + 2)) < 26) {
                dp[i] = 1;
            } else {
                dp[i] = 1 + dp[i + 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];

    }

}
//leetcode submit region end(Prohibit modification and deletion)


//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 440 👎 0
