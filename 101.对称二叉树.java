/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        if (left != null)
            stack1.push(left);
        if (right != null)
            stack2.push(right);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            left = stack1.pop();
            right = stack2.pop();
            if (left.val != right.val)
                return false;
            if (left.right == null && right.left ==null) {}
            else if (left.right == null || right.left == null) {
                return false;
            }else {
                stack1.push(left.right);
                stack2.push(right.left);
            }
            if (left.left == null && right.right == null) {}
            else if (left.left == null || right.right == null) {
                return false;
            }else {
                stack1.push(left.left);
                stack2.push(right.right);
            }
        }
        return stack1.size() == stack2.size();
    }

}

// @lc code=end
