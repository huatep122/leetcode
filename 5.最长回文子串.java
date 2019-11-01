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
}
// @lc code=end

