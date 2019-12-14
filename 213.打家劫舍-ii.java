/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] nums1 = new int[nums.length-1];
        int[] nums2 = new int[nums.length-1];
        for (int i = 0; i < nums.length-1; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i+1];
        }
        return Math.max(rob1(nums1), rob1(nums2));
    }

    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
// @lc code=end
