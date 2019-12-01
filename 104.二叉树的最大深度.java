/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public int maxDepth(TreeNode root) {
    //     return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }

    public static int maxDepth(TreeNode head) {
        if (head == null) return 0;
        Deque<NodeInfo> stack = new LinkedList<>();
        int maxHeight = Integer.MIN_VALUE;
        int height = 1;
        stack.push(new NodeInfo(head,height));
        head = head.left;
        while (!stack.isEmpty() || head!=null) {
            while (head!=null) {
                stack.push(new NodeInfo(head,++height));
                head = head.left;
            }
            NodeInfo curNode = stack.pop();
            height = curNode.height;
            maxHeight = Math.max(curNode.height, maxHeight);
            head = curNode.node.right;
        }
        return maxHeight;
    }
}

class NodeInfo {
    TreeNode node;
    int height;

    public NodeInfo(TreeNode node, int height) {
        this.node = node;
        this.height = height;
    }
}
// @lc code=end
