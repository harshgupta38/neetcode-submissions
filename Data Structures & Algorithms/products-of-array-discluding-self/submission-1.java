class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, mul = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = mul;
            mul *= nums[i];
        }
        mul=1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= mul;
            mul *= nums[i];
        }
        return ans;
    }
}
