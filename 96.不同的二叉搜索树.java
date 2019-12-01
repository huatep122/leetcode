/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if (n < 2) return 1;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        // 节点个数从1-n
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }
        return nums[n];
    }
}
// @lc code=end
