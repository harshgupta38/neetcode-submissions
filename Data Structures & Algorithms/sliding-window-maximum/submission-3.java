class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n==1 || k==1)
            return nums;

        Deque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) 
                queue.pollLast();
            queue.offer(i);

            if (queue.peekFirst() <= i - k)
                queue.pollFirst();

            if (i >= k-1)
                ans[i - k + 1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
