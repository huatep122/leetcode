/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    int res;
    int cur;

    public int kthSmallest(TreeNode root, int k) {
        help1(root, k);
        return res;
    }

    public void help1(TreeNode root, int k) {
        if (root == null)
            return;
        help1(root.left, k);
        cur++;
        if (cur == k)
            res = root.val;
        help1(root.right, k);
    }
}
// @lc code=end
