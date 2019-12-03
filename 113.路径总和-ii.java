/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return help(result, list, root, sum);
    }

    public List<List<Integer>> help(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
        if (root == null)
            return result;
        if (sum == root.val && root.left == null && root.right == null) {
            list.add(root.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
        list.add(root.val);
        result = help(result, list, root.left, sum-root.val);
        result = help(result, list, root.right, sum-root.val);
        list.remove(list.size()-1);
        return result;}
}
// @lc code=end
