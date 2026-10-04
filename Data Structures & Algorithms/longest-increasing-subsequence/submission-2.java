class Solution {
    private int[][] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n + 1];

        for (int[] row : memo) Arrays.fill(row, -1);

        return helper(nums, 0, -1);
    }

    private int helper(int[] nums, int i, int prevIndex) {
        if (i == nums.length)
            return 0;

        if (memo[i][prevIndex + 1] != -1)
            return memo[i][prevIndex + 1];

        int skip = helper(nums, i + 1, prevIndex);
        int taken = 0;
        if (prevIndex == -1 || nums[prevIndex] < nums[i]) 
            taken = 1 + helper(nums, i + 1, i);

        return memo[i][prevIndex + 1] = Math.max(taken, skip);
    }
}
