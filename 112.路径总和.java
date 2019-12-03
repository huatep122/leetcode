/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null)
    //         return false;
    //     if (sum == root.val && root.left == null && root.right == null)
    //         return true;
    //     return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    // }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();

        nodeStack.push(root);
        sumStack.push(sum);
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop();
            sum = sumStack.pop();

            if (root.val == sum && root.left == null && root.right == null) {
                return true;
            }
            if (root.right != null) {
                nodeStack.push(root.right);
                sumStack.push(sum - root.val);
            }
            if (root.left != null) {
                nodeStack.push(root.left);
                sumStack.push(sum - root.val);
            }
        }
        return false;
    }
}
// @lc code=end
