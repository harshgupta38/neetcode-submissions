class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // val, freq

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] ans = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) ans[i++] = minHeap.poll()[0];
        return ans;
    }
}
