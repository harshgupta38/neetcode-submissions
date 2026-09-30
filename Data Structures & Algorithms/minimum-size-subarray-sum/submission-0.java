class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0, l = 0, r = 0, ans = n + 1;
        while (r < n) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
            ++r;
        }
        return ans == n + 1 ? 0 : ans;
    }
}