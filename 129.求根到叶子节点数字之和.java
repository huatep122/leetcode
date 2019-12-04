/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return help(root, 0, 0);
    }

    public int help(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return sum;
        }
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curSum;
        }
        sum = help(root.left, sum, curSum);
        sum = help(root.right, sum, curSum);
        curSum -= root.val;
        return sum;
    }
}
// @lc code=end

