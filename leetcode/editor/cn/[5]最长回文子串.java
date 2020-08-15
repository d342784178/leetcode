//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i][j]表示s[i-j]为回文串
     * dp[i][j]=dp[i+1][j-1]&&a[i]==a[j]
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];

        if (s.length() <= 0) {
            return "";
        }
        int mlength = 0;
        int index   = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[j][i] = true;
                } else {
                    boolean pre = j + 1 > i - 1 || dp[j + 1][i - 1];
                    dp[j][i] = pre && s.charAt(j) == s.charAt(i);
                }
                if (dp[j][i]) {
                    //System.out.println(s.substring(j,i+1));
                    if (i - j >= mlength) {
                        mlength = i - j;
                        index = j;
                    }
                }
            }
        }
        return s.substring(index, index + mlength + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2438 👎 0
