/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 */

// @lc code=start
class Solution {
    // dp
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] nums_ = new int[m+2];
        nums_[0] = 1;
        nums_[m+1] = 1;
        for (int i = 0; i < m; i++){
            nums_[i +1] = nums[i];
        }
        int[][] dp = new int[m+2][m+2];
        for (int i = 1; i <= m; i++) {
            dp[i][i] = nums_[i-1]*nums_[i]*nums_[i+1];
        }

        for (int i = m-1;i >0;i--) {
            for (int j =i+1;j <=m;j++) {
                dp[i][j] = Math.max(
                    nums_[i-1]*nums_[i]*nums_[j+1] + dp[i+1][j],
                    nums_[i-1]*nums_[j]*nums_[j+1] + dp[i][j-1]
                );
                for (int k=i+1;k<j;k++) {
                    dp[i][j] = Math.max(
                        dp[i][j],
                        nums_[i-1]*nums_[k]*nums_[j+1] + dp[i][k-1] + dp[k+1][j]
                    );
                }
            }
        }
        return dp[1][m];

    }


    // dfs超时
    // public int maxCoins(int[] nums) {
    //     int[] nums_ = new int[nums.length+2];
    //     nums_[0] = 1;
    //     nums_[nums.length+1] = 1;
    //     for (int i = 0; i < nums.length; i++){
    //         nums_[i+1] = nums[i];
    //     }
    //     if (nums.length==0) return 0;
    //     return dfs(1,nums.length,nums_);
    // }
    // public int dfs(int left,int right,int[] nums){
    //     if (left==right) return nums[left-1] * nums[left] *nums[right+1];
    //     int result =  Math.max(
    //         nums[left-1]*nums[left]*nums[right+1] + dfs(left+1,right,nums), 
    //         nums[left-1]*nums[right]*nums[right+1] + dfs(left,right-1,nums));
    //     for(int i = left+1; i < right; i++){
    //         result = Math.max(result,nums[left-1]*nums[i]*nums[right+1] + dfs(left,i-1,nums) + dfs(i+1,right,nums));
    //     }
    //     return result;
    // }
}
// @lc code=end

