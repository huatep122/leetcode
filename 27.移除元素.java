/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //left找到与val相同的值
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            //right从后面找到不是val的值
            while (right >=0 && nums[right] == val) {
                right--;
            }
            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return right + 1;

        // int i = 0;
        // for (int j = 0; j < nums.length; j++) {
        //     if (nums[j] != val) {
        //         nums[i] = nums[j];
        //         i++;
        //     }
        // }
        // return i;
    }
}
// @lc code=end

