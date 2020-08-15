import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * dp[i]表示前i个字符的子串是否可以拆分成wordDict
     * dp[i]=s.subString[0,i].endwith(w in wordDict)&&dp[i-w.length]
     * dp[0]=true
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        //将长度初始化为s.length+1,i=0默认为true.
        //注意i是长度不是下标
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int ii = 0; ii < s.length(); ii++) {
            //注意ii是下标,而i是长度 i=ii+1
            int    i    = ii + 1;
            String stmp = s.substring(0, i);
            //System.out.println(stmp);
            for (String ss : wordDict) {
                //判断[0,ii]的子串是否可以被worddict中的单词替换 &&dp[ii]
                if (stmp.endsWith(ss) && dp[i - ss.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 596 👎 0
