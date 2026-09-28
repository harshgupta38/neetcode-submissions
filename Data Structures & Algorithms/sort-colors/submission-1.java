class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, m = 0, r = n - 1;
        while (m <= r) {
            if (nums[m] == 0) {
                nums[m] = nums[l];
                nums[l] = 0;
                ++l;
                ++m;
            } else if (nums[m] == 1) {
                ++m;
            } else {
                nums[m] = nums[r];
                nums[r] = 2;
                --r;
            }
        }
    }
}