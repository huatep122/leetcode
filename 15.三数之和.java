/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //先将数组排序
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int cur = 0; cur < nums.length - 2; cur++) {
            if (nums[cur] > 0) {
                break;
            }
            if (cur > 0 && nums[cur - 1] == nums[cur]) {
                continue;
            }
            left = cur + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[cur];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]);
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]);
                } else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[cur]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    // result.add(new ArrayList<Integer>(Arrays.asList(nums[cur], nums[left], nums[right])));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return result;
    }
}
// @lc code=end

