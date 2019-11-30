/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null)
                        return false;
                }
                break;
            }
            queue.offer(root.left==null? null:root.left);
            queue.offer(root.right==null? null:root.right);
        }
        return true;
    }
}
// @lc code=end

