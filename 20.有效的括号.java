import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    static char[] left = { '(', '{', '[' };
    static char[] right = { ')', '}', ']' };
    static HashMap<Character, Character> map = new HashMap<>();

    public boolean isValid(String s) {
        initMap();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isLeft(chars[i])) {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (map.get(chars[i]) == stack.peek()) {
                    stack.pop();
                } else
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void initMap() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public static boolean isLeft(char c) {
        for (int i = 0; i < left.length; i++) {
            if (c == left[i])
                return true;
        }
        return false;
    }

    public static boolean isRight(char c) {
        for (int i = 0; i < right.length; i++) {
            if (c == right[i])
                return true;
        }
        return false;
    }
}
// @lc code=end
