/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public int minDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     Deque<NodeInfo> stack = new LinkedList<>();
    //     int minDepth = Integer.MAX_VALUE;
    //     int height = 1;
    //     stack.push(root.left == null && root.right == null ? new NodeInfo(root, height, true)
    //             : new NodeInfo(root, height, false));
    //     root = root.left;
    //     while (!stack.isEmpty() || root != null) {
    //         while (root != null) {
    //             NodeInfo n = root.left == null && root.right == null ? new NodeInfo(root, ++height, true)
    //                     : new NodeInfo(root, ++height, false);
    //             stack.push(n);
    //             root = root.left;
    //         }
    //         NodeInfo curNode = stack.pop();
    //         height = curNode.height;
    //         minDepth = curNode.isLeaf ? Math.min(minDepth, curNode.height) : minDepth;
    //         root = curNode.node.right;
    //     }
    //     return minDepth;
    // }

    public int minDepth(TreeNode root) {
        return root == null ? 0 : help(root,1);
    }

    public int help(TreeNode root, int level) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return level;
        }
        int left = help(root.left, level+1);
        int right = help(root.right, level+1);
        return Math.min(left, right);
    }

}

class NodeInfo {
    TreeNode node;
    int height;
    boolean isLeaf;

    public NodeInfo(TreeNode node, int height, boolean isLeaf) {
        this.node = node;
        this.height = height;
        this.isLeaf = isLeaf;
    }
}
// @lc code=end
