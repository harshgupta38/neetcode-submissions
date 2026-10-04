class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int nMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            int nMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));

            max = nMax;
            min = nMin;

            ans = Math.max(ans, max);
        }
        return ans;
    }
}