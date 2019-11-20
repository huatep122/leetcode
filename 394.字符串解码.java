/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> data = new Stack<>();
        Stack<Character> helper = new Stack<>();
        int mutil = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i]) >='0' && (chars[i] <= '9')) {
                mutil = mutil * 10 + Integer.parseInt(chars[i]+"");
            }else if (chars[i]==']'){
                int curNum = num.pop();
                while(!data.isEmpty() && data.peek()!='['){
                    char c = data.pop();
                    helper.push(c);
                }
                if (!data.isEmpty())
                    data.pop();
                char[] curChars = new char[helper.size()];
                int cur = 0;
                while (!helper.isEmpty()) {
                    curChars[cur] = helper.pop();
                    cur++;
                }
                for (int j = 0;j<curNum;j++){
                    for (int k = 0; k <curChars.length;k++) {
                        data.push(curChars[k]);
                    }
                }
                curChars =null;
            }else if (chars[i] == '['){
                num.push(mutil);
                mutil = 0;
                data.push(chars[i]);
            }else data.push(chars[i]);
        }
        while (!data.isEmpty()) {
            helper.push(data.pop());
        }
        char[] curChars = new char[helper.size()];
        int cur = 0;
        while (!helper.isEmpty()) {
            curChars[cur] = helper.pop();
            cur++;
        }
        return String.valueOf(curChars);
    }
}
// @lc code=end

