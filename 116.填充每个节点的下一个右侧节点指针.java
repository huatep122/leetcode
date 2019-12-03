/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {

    Node p1 = null;
    Node p2 = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        p1 = root.left;
        p2 = root.right;
        while (p1 != null) {
            p1.next = p2;
            p1 = p1.right;
            p2 = p2.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
// @lc code=end

