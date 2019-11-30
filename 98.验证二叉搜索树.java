/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // return dfs(root,null,null);
        return root == null ? true : isBST(root).isValid;
        // return inOrder(root);
    }
    // 左神的套路
    public ReturnType isBST(TreeNode head) {
        if (head.left == null && head.right == null) {
            return new ReturnType(true, head.val, head.val);
        }
        if (head.left == null) {
            ReturnType rData = isBST(head.right);
            boolean isValid = rData.isValid && head.val < rData.min;
            int max = isValid ? rData.max : Math.max(head.val, rData.max);
            int min = isValid ? head.val : Math.min(head.val, rData.min);
            return new ReturnType(isValid, max, min);
        } else if (head.right == null) {
            ReturnType lData = isBST(head.left);
            boolean isValid = lData.isValid && head.val > lData.max;
            int max = isValid ? head.val : Math.max(head.val, lData.max);
            int min = isValid ? lData.min : Math.min(head.val, lData.min);
            return new ReturnType(isValid, max, min);
        } else {
            ReturnType lData = isBST(head.left);
            ReturnType rData = isBST(head.right);
            boolean isValid = lData.isValid && rData.isValid && head.val > lData.max && head.val < rData.min;
            int max = isValid ? rData.max : Math.max(head.val, Math.max(lData.max, rData.max));
            int min = isValid ? lData.min : Math.min(head.val, Math.min(lData.min, rData.min));
            return new ReturnType(isValid, max, min);
        }
    }
    // 二叉搜索树特性，左子树都比根小，右子树都比根大，根范围是(负无穷，正无穷)，左子树范围(负无穷，根的值)，右子树范围(根的值，正无穷)
    public boolean dfs(TreeNode head, Integer min, Integer max) {
        if (head == null) {
            return true;
        }
        // if (head.val < max && head.val > min && dfs(head.left, min, head.val) &&
        // dfs(head.right,head.val, max)) {
        // return true;
        // }
        // return false;
        if (min != null && head.val <= min)
            return false;
        if (max != null && head.val >= max)
            return false;
        if (!dfs(head.left, min, head.val))
            return false;
        if (!dfs(head.right, head.val, max))
            return false;
        return true;
    }

    // 非递归中序遍历
    public static boolean inOrder(TreeNode head) {
        Deque<TreeNode> stack = new LinkedList<>();
        Integer pre = null;
        while (!stack.isEmpty() || head != null) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            head = stack.pop();
            if (pre != null && head.val <= pre)
                return false;
            pre = head.val;
            head = head.right;
        }
        return true;
    }

}

class ReturnType {
    boolean isValid;
    int max;
    int min;

    public ReturnType(boolean isValid, int max, int min) {
        this.isValid = isValid;
        this.max = max;
        this.min = min;
    }
}
// @lc code=end
