class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1)
            return false;

        return check(nums, sum/2, 0);
    }

    private boolean check(int[] nums, int target, int i){
        if(target<0) return false;
        if(target==0) return true;
        if(i>=nums.length) return target==0;

        if(check(nums, target-nums[i], i+1)) return true;

        return check(nums, target, i+1);
    }
}
