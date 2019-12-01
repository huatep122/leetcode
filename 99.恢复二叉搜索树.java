/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode mark1 = null;
        TreeNode mark2 = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val > root.val) {
                mark1 = mark1 == null ? pre : mark1;
                mark2 = root;
            }
            pre = root;
            root = root.right;
        }
        int temp = mark1.val;
        mark1.val = mark2.val;
        mark2.val = temp;
    }
}
// @lc code=end
