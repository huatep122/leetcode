/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    // 暴力递归，超时
    public int minCostClimbingStairs0(int[] cost) {
        return dfs(0,cost)<dfs(1,cost)? dfs(0,cost):dfs(1,cost);
    }
    int dfs(int k,int[] cost){
        if(k<cost.length){
            int res = cost[k];
            return res+dfs(k+1,cost)<res+dfs(k+2,cost) ? res+dfs(k+1,cost):res+dfs(k+2,cost);
        }else return 0;
    }
    // 动态规划
    public int minCostClimbingStairs1(int[] cost) {
        if (cost == null) return 0;
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0],cost[1]);
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        return dp[cost.length];
    }
    //状态压缩
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null) return 0;
        if (cost.length == 1) return cost[0];
        int k1 = cost[1];
        int k2 = cost[0];
        for (int i =2; i <cost.length; i++) {
            int min = Math.min(k1+cost[i], k2+cost[i]);
            k2 = k1;
            k1 = min;
        }
        return Math.min(k1, k2);
    }
}
// @lc code=end

