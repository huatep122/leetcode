/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[N][i] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= amount; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                if (rest - coins[i] >= 0 && dp[i][rest - coins[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        dp[i][rest] = dp[i][rest - coins[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest - coins[i]] + 1, dp[i + 1][rest]);
                    }
                }
            }
        }
        return dp[0][amount];
    }

    public int process(int[] coins, int cur, int rest) {
        if (cur == coins.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int i = 0; i * coins[cur] <= rest; i++) {
            int next = process(coins, cur + 1, rest - i * coins[cur]);
            if (next != -1) {
                res = res == -1 ? next + i : Math.min(res, next + i);
            }
        }
        return res;
    }

}
// @lc code=end
