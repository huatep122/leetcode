/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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

    private int count;
    private int cur;
    public int pathSum(TreeNode root, int sum) {
        help1(root, sum);
        return count;
    }

    public void help1(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        help(root, sum);
        help1(root.left, sum);
        help1(root.right, sum);
    }
    // root节点有多少个路径
    public void help(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (cur == sum) {
            count++;
        }
        help(root.left, sum);
        help(root.right, sum);
        cur -= root.val;
    }
}
// @lc code=end

