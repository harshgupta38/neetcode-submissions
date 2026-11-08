class Solution {
    public int maxArea(int[] nums) {
        int max = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) {
                max = Math.max(max, nums[l] * (r - l));
                ++l;
            } else {
                max = Math.max(max, nums[r] * (r - l));
                --r;
            }
        }
        return max;
    }
}
