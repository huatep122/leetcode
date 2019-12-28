/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
            for (int j = i + 1; j < length; j++) {
                max = Math.max(max, nums[j]);
                dp[j] = nums[j] * dp[j - 1];
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ 
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            max = Math.max(max, imax);
        }
        return max;
    }
}
// @lc code=end
