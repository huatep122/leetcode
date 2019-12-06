/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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

    private int count=0;
    public int sumOfLeftLeaves(TreeNode root) {
        help(root);
        return count;
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left==null&&root.left.right == null) {
            count+=root.left.val;
        }
        help(root.left);
        help(root.right);
    }
}
// @lc code=end

