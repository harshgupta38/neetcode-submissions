class Solution {
    public int[] replaceElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = max;
            max = Math.max(max, nums[i]);
        }
        return ans;
    }
}