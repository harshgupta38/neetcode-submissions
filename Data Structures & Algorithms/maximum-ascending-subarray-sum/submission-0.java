class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0], max=nums[0], n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
                max=Math.max(max, sum);
            } else {
                sum=nums[i];
            }
        }
        return max;
    }
}