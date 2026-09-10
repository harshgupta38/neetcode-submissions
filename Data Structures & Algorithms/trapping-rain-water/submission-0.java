class Solution {
    public int trap(int[] nums) {
        int left=0, leftMax=0;
        int right=nums.length-1, rightMax=0;
        int sum=0;
        while(left<right){
            if(nums[left]<nums[right]){
                if(leftMax<nums[left])
                    leftMax=nums[left];
                else   
                    sum+=leftMax-nums[left];
                ++left;
            } else {
                if(rightMax<nums[right])
                    rightMax=nums[right];
                else   
                    sum+=rightMax-nums[right];
                --right;
            }
        }
        return sum;
    }
}
