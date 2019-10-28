/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    // 递归求解
    public boolean isSubsequence0(String s, String t) {
        if (s.length()==0) return true;
        char c = s.charAt(0);
        int index = t.indexOf(c);
        if (index == -1) return false;
        else return isSubsequence0(s.substring(1),t.substring(index+1));
    }
    // 双指针，判断s上指针的位置
    public boolean isSubsequence1(String s, String t) {
        int i=0; 
        int j=0;
        while (i<s.length() && j<t.length()) {
            if (s.charAt(i)==t.charAt(j)) i++;
            j++;
        }
        return i==s.length();
    }
}
// @lc code=end

