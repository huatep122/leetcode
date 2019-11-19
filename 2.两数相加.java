/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int cal = 0;
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null? 0:l1.val;
            int num2 = l2 == null? 0:l2.val;
            int cur = cal + num1 + num2;
            ListNode node = new ListNode(cur % 10);
            cal = cur / 10;
            tail.next = node;
            tail = node;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (cal!=0) {
            tail.next = new ListNode(1);
        }
        return newHead.next;
    }
}
// @lc code=end
