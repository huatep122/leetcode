/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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

    List<String> result = new ArrayList<>();
    String str = "";
    public List<String> binaryTreePaths(TreeNode root) {
        help(root);
        return result;
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(str+root.val);
        }else {
            str = str + root.val + "->";
            help(root.left);
            help(root.right);
            str = str.substring(0,str.lastIndexOf(root.val+""));
        }
    }
}
// @lc code=end

