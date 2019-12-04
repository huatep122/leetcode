/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        TreeNode p = root;
        while (p.left != null) {
            height++;
            p = p.left;
        }
        return help(root,height,1);
    }

    public static int help(TreeNode root, int height, int level) {
        int count = 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int l = level;
        TreeNode p = root.right;
        while (p != null) {
            l++;
            p = p.left;
        }
        if (height == l) {
            count += Math.pow(2, height-level);
            count += help(root.right, height,level+1);
        }else {
            count += Math.pow(2, height-level-1);
            count += help(root.left, height,level+1);
        }
        return count;
    }

}
// @lc code=end

