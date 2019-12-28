/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<String>(wordDict));
    }

    public boolean process(String s, Set<String> dict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && process(s, dict, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean helper(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        int end = s.length();
        for (int start = end - 1; start >=0; start--) {
            dp[start] = dp[end] && dict.contains(s.substring(start,end));
            if (dp[start]) {
                end = start;
            }
        }
        return dp[0];
    }
}
// @lc code=end
