/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generate(1,n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start>end) {
            result.add(null);
        }
        TreeNode head = null;
        for (int i=start; i <end+1; i++) {
            List<TreeNode> leftRes =  generate(start, i-1);
            List<TreeNode> rightRes = generate(i+1,end);
            head = new TreeNode(i);
            for (TreeNode l : leftRes) {
                for (TreeNode r : rightRes) {
                    head.left = l;
                    head.right = r;
                    result.add(colneTree(head));
                }
            }
        }
        return result;
    }

    public TreeNode colneTree(TreeNode head) {
        if (head == null) return null;
        TreeNode result = new TreeNode(head.val);
        result.left = colneTree(head.left);
        result.right = colneTree(head.right);
        return result;
    }
}
// @lc code=end

