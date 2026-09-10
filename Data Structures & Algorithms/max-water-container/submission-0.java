class Solution {
    public int maxArea(int[] nums) {
        int l=0, r=nums.length-1;
        int max=0;
        while(l<r){
            int width=r-l;
            if(nums[l]<nums[r]){
                max=Math.max(max, nums[l]*width);
                ++l;
            } else {
                max=Math.max(max, nums[r]*width);
                --r;
            }
        }
        return max;
    }
}
