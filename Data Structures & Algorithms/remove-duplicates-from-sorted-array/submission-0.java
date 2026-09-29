class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0, r = 1;
        while (r < n) {
            if (nums[l] != nums[r])
                nums[++l] = nums[r];
            ++r;
        }
        return l+1;
    }
}