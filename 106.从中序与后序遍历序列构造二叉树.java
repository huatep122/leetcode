/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(map, inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode help(HashMap<Integer, Integer> map, int[] inorder, int[] postorder, int inStart, int inEnd,
            int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postEnd]);
        int index = map.get(head.val);
        int leftNodeCount = index - inStart;
        head.left = help(map, inorder, postorder, inStart, inStart + leftNodeCount - 1, postStart,
                postStart + leftNodeCount - 1);
        head.right = help(map, inorder, postorder, index + 1, inEnd, postStart + leftNodeCount, postEnd - 1);
        return head;
    }
}
// @lc code=end
