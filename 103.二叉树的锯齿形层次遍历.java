import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        boolean leftToRight = true;
        int curLevelCount = 1;
        int nextLevelCount = 0;
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < curLevelCount; i++) {
                if (leftToRight) {
                    root = deque.pollFirst();
                    list.add(root.val);
                    if (root.left != null) {
                        nextLevelCount++;
                        deque.offerLast(root.left);
                    }
                    if (root.right != null) {
                        nextLevelCount++;
                        deque.offerLast(root.right);
                    }
                } else {
                    root = deque.pollLast();
                    list.add(root.val);
                    if (root.right != null) {
                        nextLevelCount++;
                        deque.offerFirst(root.right);
                    }
                    if (root.left != null) {
                        nextLevelCount++;
                        deque.offerFirst(root.left);
                    }
                }
            }
            leftToRight = leftToRight == true ? false : true;
            curLevelCount = nextLevelCount;
            nextLevelCount = 0;
            result.add(list);
        }
        return result;
    }
}
// @lc code=end
