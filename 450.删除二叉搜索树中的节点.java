/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode deleteNode(TreeNode p, int key) {
        TreeNode root = p;
        TreeNode parent = null;
        while (root != null) {
            if (root.val < key) {
                parent = root;
                root = root.right;
            } else if (root.val > key) {
                parent = root;
                root = root.left;
            } else {
                break;
            }
        }
        if (root == null) {
            return p;
        }
        if (root == p) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }else {
                parent = root;
                TreeNode node = root.left;
                while (node.right != null) {
                    parent = node;
                    node = node.right;
                }
                root.val = node.val;
                if (parent == root) {
                    if (node.left == null && node.right == null) {
                        parent.left = null;
                    } else {
                        parent.left = node.left;
                    }
                }else {
                    if (node.left == null && node.right == null) {
                        parent.right = null;
                    } else {
                        parent.right = node.left;
                    }
                }
            }
        } else {
            if (root.left == null && root.right == null) {
                if (parent.val < root.val) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
            } else if (root.left == null || root.right == null) {
                if (parent.val < root.val) {
                    parent.right = root.left != null ? root.left : root.right;
                } else {
                    parent.left = root.left != null ? root.left : root.right;
                }
            } else {
                parent = root;
                TreeNode node = root.left;
                while (node.right != null) {
                    parent = node;
                    node = node.right;
                }
                root.val = node.val;
                if (parent == root) {
                    if (node.left == null && node.right == null) {
                        parent.left = null;
                    } else {
                        parent.left = node.left;
                    }
                }else {
                    if (node.left == null && node.right == null) {
                        parent.right = null;
                    } else {
                        parent.right = node.left;
                    }
                }
            }
        }
        return p;
        // 1. 左右孩子均为空，直接将父节点指向空即可
        // 2. 左孩子或右孩子为空，将父节点指向不为空的一个
        // 3. 左右孩子均不为空，用左子树最右侧几点值替换。
    }
}
// @lc code=end
