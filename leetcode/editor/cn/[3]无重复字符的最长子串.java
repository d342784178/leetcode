//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 3951 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 思路: 使用i,j两个指针滑动窗口
        // 如果set.contains(j)则set.remove(i)直到set不含有j
        // 如果!set.contains(j)则将j添加到set中.同时使用ml保存最大长度
        Set set = new LinkedHashSet();
        int i = 0, j = 0, l = s.length();
        int ml = 0;
        while (i < l && j < l) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ml = Math.max(ml, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ml;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
