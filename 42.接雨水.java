/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        /**
         * 1.计算数组和sum1
         * 2.依次将height数组的非零下标压入栈中，设要压入的下标为i，当前栈顶的下标为curIndex，如果height[i]<height[curIndex]则直接将i压入；否则将curIndex弹出，下标i代表的是curIndex代表高度右侧最近一个比它高的，所以将i-curIndex之间的位置补齐至height[curIndex]同样高度。curIndex左侧的补齐会被下一个栈顶元素preIndex或后面的下标i出栈时覆盖掉，所以只要能保证curIndex出栈就好。
         * 3.在下标都进过栈后，还需要将他们都出栈，例如样例[6,0,5,0,1].步骤2中不曾有下标出栈，但是里面还是可以积水，所以将其都出栈此时只需要考虑左侧部分即可
         * 4.计算数组和sum2 
         * sum2 - sum1就是接水量
         */
        int sum1 = 0;
        int sum2 = 0;
        int length = height.length;
        // 单调栈，用来求一个元素右侧第一个大于或等于它的值
        Deque<Integer> stack = new LinkedList<>();
        // 1. 计算sum1
        for (int i = 0; i < length; i++) {
            sum1 += height[i];
        }
        // 栈中压入-1作为左边界
        stack.push(-1);
        // 2.将下标压入栈
        for (int i = 0; i < length; i++) {
            if (height[i] != 0) {
                while (stack.peek() != -1 && height[i] >= height[stack.peek()]) {
                    // 栈顶元素为curIndex，先扩展右侧
                    int curIndex = stack.pop();
                    for (int k = curIndex + 1; k < i; k++) {
                        // 补齐
                        height[k] = height[curIndex];
                    }
                }
                stack.push(i);
            }
        }
        while (stack.peek() != -1) {
            int curIndex = stack.pop();
            int preIndex = stack.peek();
            // 如果左侧有比curIndex高的位置，则把他们之间部分补齐成curIndex的高度
            if (preIndex != -1) {
                for (int k = preIndex + 1; k < curIndex; k++) {
                    height[k] = height[curIndex];
                }
            }
        }
        // 3.计算sum2
        for (int i = 0; i < length; i++) {
            sum2 += height[i];
        }
        return sum2 - sum1;
    }
}
// @lc code=end
