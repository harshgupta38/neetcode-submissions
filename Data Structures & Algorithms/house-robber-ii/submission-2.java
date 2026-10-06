class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

    private int rob(int[] nums, int left, int right){
        int n=nums.length;
        int[] dp=new int[n];
        dp[left]=nums[left];
        dp[left+1]=Math.max(nums[left], nums[left+1]);
        for(int i=left+2;i<=right;i++)
        dp[i]=Math.max(dp[i-2]+nums[i], dp[i-1]);
        return dp[right];
    }
}
