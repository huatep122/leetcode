/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length()+1;
        int n = word2.length()+1;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0]+1; 
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1]+1;
        }
        for (int i = 1; i <m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j]);
                    dp[i][j] = Math.min(dp[i][j-1]+1, dp[i][j]);
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }
}
// @lc code=end

