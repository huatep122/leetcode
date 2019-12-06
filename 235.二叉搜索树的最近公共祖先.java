/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null || root == p || root == q) {
    //         return root;
    //     }
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     if (left != null && right != null) {
    //         return root;
    //     }
    //     return left == null ? right : left;
    // }
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    private Set<TreeNode> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map.put(root, null);
        setMap(root);
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (q != null && !set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    public void setMap(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        setMap(root.left);
        setMap(root.right);
    }
}
// @lc code=end
