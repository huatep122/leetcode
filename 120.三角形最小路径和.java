/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) return 0;
        if (m == 1) return triangle.get(0).get(0);
        // int[][] dp  = new int[m][m];
        for (int i = 1; i < m; i++) {
            triangle.get(i).set(0,triangle.get(i-1).get(0)+triangle.get(i).get(0)); 
            triangle.get(i).set(i,triangle.get(i-1).get(i-1)+triangle.get(i).get(i));
        }
        for (int i = 2; i < m; i++) {
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(j,Math.min(triangle.get(i-1).get(j-1)+triangle.get(i).get(j),triangle.get(i-1).get(j)+triangle.get(i).get(j)));
            }
        }
        return Collections.min(triangle.get(m-1));

    }
}
// @lc code=end

