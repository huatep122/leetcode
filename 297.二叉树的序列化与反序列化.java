/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //byPre
        // if (root == null) {
        //     return "#!";
        // }
        // String res = root.val + "!";
        // res+=serialize(root.left);
        // res+=serialize(root.right);
        // return res;

        // byLevel
        if (root == null) {
            return "#!";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String res = "";
        queue.offer(root);
        res+=root.val+"!";
        while (!queue.isEmpty()) {
            TreeNode node= queue.poll();
            if (node.left != null) {
                res+=node.left.val+"!";
                queue.offer(node.left);
            }else {
                res+="#!";
            }
            if (node.right != null) {
                res+=node.right.val+"!";
                queue.offer(node.right);
            }else {
                res+="#!";
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //byPre
        // String[] values = data.split("!");
        // Queue<String> queue = new LinkedList<>();
        // for (int i = 0; i < values.length; i++) {
        //     queue.offer(values[i]);
        // }
        // return help(queue);

        //byLevel
        String[] values = data.split("!");
        if (values[0].equals("#")) return null;
        int index=1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(values[0]));
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            cur.left = values[index].equals("#")? null:new TreeNode(Integer.valueOf(values[index]));
            index++;
            cur.right = values[index].equals("#")? null:new TreeNode(Integer.valueOf(values[index]));
            index++;
            if (cur.left!=null) queue.offer(cur.left);
            if (cur.right!=null) queue.offer(cur.right);
        }
        return head;
    }

    public TreeNode help(Queue<String> queue) {
        String poll = queue.poll();
        if (poll.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(poll));
        head.left = help(queue);
        head.right = help(queue);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

