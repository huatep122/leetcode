/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return root==null?true:isBST(root).isValid;
    }

    public ReturnType isBST(TreeNode head) {
        if (head.left == null && head.right == null) {
            return new ReturnType(true, head.val, head.val);
        }
        if (head.left == null) {
            ReturnType rData = isBST(head.right);
            boolean isValid = rData.isValid && head.val < rData.min;
            int max = isValid ? rData.max : Math.max(head.val, rData.max);
            int min = isValid ? head.val : Math.min(head.val, rData.min);
            return new ReturnType(isValid, max, min);
        } else if (head.right == null) {
            ReturnType lData = isBST(head.left);
            boolean isValid = lData.isValid && head.val > lData.max;
            int max = isValid ? head.val : Math.max(head.val, lData.max);
            int min = isValid ? lData.min : Math.min(head.val, lData.min);
            return new ReturnType(isValid, max, min);
        } else {
            ReturnType lData = isBST(head.left);
            ReturnType rData = isBST(head.right);
            boolean isValid = lData.isValid && rData.isValid && head.val > lData.max && head.val < rData.min;
            int max = isValid ? rData.max : Math.max(head.val, Math.max(lData.max, rData.max));
            int min = isValid ? lData.min : Math.min(head.val, Math.min(lData.min, rData.min));
            return new ReturnType(isValid, max, min);
        }
    }

}

class ReturnType {
    boolean isValid;
    int max;
    int min;

    public ReturnType(boolean isValid, int max, int min) {
        this.isValid = isValid;
        this.max = max;
        this.min = min;
    }
}
// @lc code=end
