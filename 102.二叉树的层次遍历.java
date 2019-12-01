/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int curLevelCount = 1;
        int nextLevelCount = 0;
        queue.offer(root);
        TreeNode curNode = null;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < curLevelCount; i++) {
                curNode = queue.poll();
                list.add(curNode.val);
                if (curNode.left!=null) {
                    nextLevelCount++;
                    queue.offer(curNode.left);
                }
                if (curNode.right!= null) {
                    nextLevelCount++;
                    queue.offer(curNode.right);
                }
            }
            curLevelCount = nextLevelCount;
            nextLevelCount = 0;
            result.add(list);
        }
        return result;
    }
}
// @lc code=end

