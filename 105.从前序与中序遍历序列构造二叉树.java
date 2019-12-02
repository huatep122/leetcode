/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode help(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start >pre_end) return null;
        TreeNode head = new TreeNode(preorder[pre_start]);
        int index = getIndex(inorder, preorder[pre_start], in_start, in_end);
        int leftNodeCount = index - in_start;
        head.left = help(preorder, inorder, pre_start + 1, pre_start + leftNodeCount, in_start,
                in_start + leftNodeCount - 1);
        head.right = help(preorder, inorder,pre_start+leftNodeCount+1,pre_end,index+1,in_end);
        return head;
    }

    public int getIndex(int[] inorder, int val, int in_start, int in_end) {
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
