/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if (root == null) {
            result += "#!";
            return result;
        }
        result = result + root.val + "!";
        result += serialize(root.left);
        result += serialize(root.right);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.add(strings[i]);
        }
        return help(queue);
    }

    public TreeNode help(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(cur));
        head.left = help(queue);
        head.right = help(queue);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
