class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int count = 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int sum = l == r ? nums[l] : nums[l] + nums[r];
            if (sum > limit) {
                ++count;
                --r;
            } else {
                ++count;
                ++l;
                --r;
            }
        }
        return count;
    }
}