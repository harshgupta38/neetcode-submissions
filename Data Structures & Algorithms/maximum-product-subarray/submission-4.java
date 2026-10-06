class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], prod = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            int min = Math.min(nums[i], Math.min(maxProd * nums[i], minProd * nums[i]));

            maxProd = max;
            minProd = min;

            ans = Math.max(maxProd, ans);
        }
        return ans;
    }
}
