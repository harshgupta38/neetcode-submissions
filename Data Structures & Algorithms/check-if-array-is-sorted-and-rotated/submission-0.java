class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        int drop = 0;
        for (int i = 1; i < n; i++)
            if (nums[i - 1] > nums[i])
                ++drop;

        if (nums[0] < nums[n - 1] && drop>0)
            return false;

        return drop <= 1;
    }
}