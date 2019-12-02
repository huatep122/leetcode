/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<List<Integer>> stack = new LinkedList<>();
        int curLevelCount = 1;
        int nextLevelCount = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < curLevelCount; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    nextLevelCount++;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    nextLevelCount++;
                    queue.offer(node.right);
                }
            }
            stack.push(list);
            curLevelCount = nextLevelCount;
            nextLevelCount = 0;
        } 
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
// @lc code=end

