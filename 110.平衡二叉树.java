/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return help(root).isBalanced;
    }

    public ReturnType help(TreeNode root) {
        if (root == null)
            return new ReturnType(true, 0);
        ReturnType lData = help(root.left);
        ReturnType rData = help(root.right);
        int height = Math.max(lData.height, rData.height) + 1;
        boolean isBalanced = lData.isBalanced && rData.isBalanced && Math.abs(lData.height - rData.height) < 2;
        return new ReturnType(isBalanced, height);
    }
}

class ReturnType {
    boolean isBalanced;
    int height;

    public ReturnType(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}
// @lc code=end
