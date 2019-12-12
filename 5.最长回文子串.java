/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (s.length()==0) return "";
        String result = null;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                start--;
                end++;
            }
            start = i;
            end = i+1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                start--;
                end++;
            }
        }
        return result;
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return "";
        }
        int resBegin = 0;
        int max = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len) {
                dp[i][i + 1] = chars[i] == chars[i + 1];
                if (dp[i][i + 1] && 2 > max) {
                    max = 2;
                    resBegin = i;
                }
            }
        }
        for (int col = 2; col < len; col++) {
            for (int row = 0; row < col-1; row++) {
                dp[row][col] = chars[row] == chars[col] && dp[row + 1][col - 1];
                if (dp[row][col] && col - row + 1 > max) {
                    max = col - row + 1;
                    resBegin = row;
                }
            }
        }
        return max == len ? s : s.substring(resBegin, resBegin + max);
    }
}
// @lc code=end

