import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    Queue<Integer> data;
    Queue<Integer> helper;
    int res;
    /** Initialize your data structure here. */
    public MyStack() {
        data = new LinkedList<>();
        helper = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        data.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (data.size()!=1) {
            res = data.poll();
            helper.offer(res);
        }
        res = data.poll();
        Queue<Integer> tmp = new LinkedList<>();
        data = helper;
        helper = tmp;
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        while (data.size()!=0) {
            res = data.poll();
            helper.offer(res);
        }
        Queue<Integer> tmp = new LinkedList<>();
        data = helper;
        helper = tmp;
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.size()==0 && helper.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

