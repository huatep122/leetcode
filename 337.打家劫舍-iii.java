/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int rob(TreeNode root) {
        // return Math.max(help(root,false),help(root,true));
        ReturnType res =  help1(root);
        return res.FalseSum >= res.TrueSum ? res.FalseSum : res.TrueSum;
    }

    public int help(TreeNode root, boolean robbing) {
        if (root == null) {
            return 0;
        }
        if (robbing) {
            return help(root.left, false) + help(root.right, false) + root.val;
        } else {
            return Math.max(help(root.left, false), help(root.left, true))
                    + Math.max(help(root.right, false), help(root.right, true));
        }
    }

    public ReturnType help1(TreeNode root) {
        if (root == null) {
            return new ReturnType(null, 0, 0);
        }
        ReturnType lData = help1(root.left);
        ReturnType rData = help1(root.right);

        int TrueSum = lData.FalseSum + rData.FalseSum + root.val;
        int FalseSum = Math.max(lData.TrueSum,lData.FalseSum) + Math.max(rData.TrueSum,rData.FalseSum);
        return new ReturnType(root, TrueSum, FalseSum);
    }


}

class ReturnType {
    TreeNode root;
    int TrueSum;
    int FalseSum;

    public ReturnType(TreeNode root, int TrueSum, int FalseSum) {
        this.root = root;
        this.TrueSum = TrueSum;
        this.FalseSum = FalseSum;
    }
}
// @lc code=end
