/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    // public int lengthOfLIS(int[] nums) {
    //     if (nums.length == 0) {
    //         return 0;
    //     }
    //     int[] dp = new int[nums.length];
    //     dp[0] = 1;
    //     int max = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         int curLen = 1;
    //         for (int j = i-1; j >= 0; j--) {
    //             if (nums[j] < nums[i]) {
    //                 curLen = Math.max(curLen, dp[j] + 1);
    //             }
    //         }
    //         dp[i] = curLen;
    //         max = Math.max(max, dp[i]);
    //     }
    //     return max;
    // }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ends = new int[nums.length];
        ends[0] = nums[0];
        int max = 1;
        int l =0;
        int r = 0;
        int m = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = l + (r - l) / 2;
                if (ends[m] < nums[i]) {
                    l = m+1;
                }else {
                    r = m-1;
                }
            }
            right = Math.max(l, right);
            ends[l] = nums[i];
            max = Math.max(max, right + 1);
        }
        return max;
    }
}
// @lc code=end

