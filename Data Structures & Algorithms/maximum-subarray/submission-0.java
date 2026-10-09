class Solution {
    public int maxSubArray(int[] nums) {
        int max=-1_000_000, sum=-1_000_000;
        for(int num:nums){
            sum=Math.max(num, num+sum);
            max=Math.max(max, sum);
        }
        return max;
    }
}
