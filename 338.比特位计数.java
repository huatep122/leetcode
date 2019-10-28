/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        if (num == 0) return bits;
        bits[0] = 0;
        bits[1] = 1;
        int j = 1;
        for (int i = 2; i < num+1; i++){
            if (i==(int)Math.pow(2,j)){
                bits[i] = 1;
                j++;
            }else {
                bits[i] = bits[(int)Math.pow(2,j-1)] + bits[i-(int)Math.pow(2,j-1)]; 
            }
        }
        return bits;
    }
}
// @lc code=end

