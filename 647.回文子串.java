/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        // i条斜线
        for (int col = 1; col < len; col++) {
            // i_暂时存储i,i_会不断变化
            int col_ = col;
            // 每条斜线从第一行开始画
            for (int row = 0; row < len-col; row++,col_++) {
                if (row + 1 == col_) {
                    dp[row][col_] = s.charAt(row) == s.charAt(col_) ? 1 : 0;
                } else if (s.charAt(row) == s.charAt(col_) && dp[row + 1][col_ - 1] == 1) {
                    dp[row][col_] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
// @lc code=end
