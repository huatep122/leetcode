/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        help(root);
    }

    public ReturnType help(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new ReturnType(root, root);
        }
        ReturnType lData = help(root.left);
        ReturnType rData = help(root.right);
        if (lData != null) {
            lData.last.right = rData == null ? null : rData.first;
            root.left = null;
            root.right = lData.first;
        }
        return new ReturnType(root, rData==null? lData.last:rData.last);
    }
}

class ReturnType {
    TreeNode first;
    TreeNode last;

    public ReturnType(TreeNode first, TreeNode last) {
        this.first = first;
        this.last = last;
    }
}
// @lc code=end
