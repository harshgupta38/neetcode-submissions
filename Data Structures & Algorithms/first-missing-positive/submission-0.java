class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, temp;
        for (int i = 0; i < n; i++) {
            int j = nums[i] - 1;
            while (j >= 0 && j < n && nums[i] != nums[j]) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }
}