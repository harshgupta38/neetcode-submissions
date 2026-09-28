class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        divide(nums, 0, n - 1);
        return nums;
    }

    private void divide(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        divide(nums, left, mid);
        divide(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n = right - left + 1;
        int[] temp = new int[n];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // Merge both sorted halves
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Remaining elements from left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Remaining elements from right half
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy back
        k = left;

        for (i = 0; i < n; i++) {
            nums[k++] = temp[i];
        }
    }
}