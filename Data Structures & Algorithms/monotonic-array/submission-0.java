class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return true;

        int data = 0; //-1, 0, 1
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                if (data == 1)
                    return false;
                data = -1;
            } else if (nums[i - 1] > nums[i]) {
                if (data == -1)
                    return false;
                data = 1;
            }
        }
        return true;
    }
}