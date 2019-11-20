/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    Stack<Integer> data;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        int curMin = min.isEmpty() ? x : min.peek() < x ? min.peek() : x;
        min.push(curMin);
    }

    public void pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        data.pop();
        min.pop();
    }

    public int top() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.peek();
    }

    public int getMin() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
