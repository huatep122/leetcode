/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row--][col--];
        if (dungeon[row][col] < 0) {
            dp[row][col] = 1 - dungeon[row][col];
        } else {
            dp[row][col] = 1;
        }
        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = Math.max(1, dp[row][i + 1] - dungeon[row][i]);
        }
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - dungeon[i][col]);
            for (int j = col-1; j >= 0; j--) {
                int right = Math.max(1, dp[i][j+1]- dungeon[i][j]);
                int down = Math.max(1, dp[i+1][j]- dungeon[i][j]);
                dp[i][j] = Math.min(right,down);
            }
        }
        return dp[0][0];
    }
}
// @lc code=end
