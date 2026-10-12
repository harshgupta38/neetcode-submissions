class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1, maxInc = 1;
        int dec = 1, maxDec = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                ++inc;
                maxInc = Math.max(maxInc, inc);
            } else
                inc = 1;

            if (nums[i] < nums[i - 1]) {
                ++dec;
                maxDec = Math.max(maxDec, dec);
            } else
                dec = 1;
        }
        return Math.max(maxInc, maxDec);
    }
}