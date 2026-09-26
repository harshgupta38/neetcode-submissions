class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[1] - b[1]); // [toIndex, time]

        minHeap.offer(new int[] {0, 0});
        int[] min = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        int cost = 0;

        while (!minHeap.isEmpty()) {
            int[] now = minHeap.poll();
            int to = now[0], time = now[1];

            if(visited[to]) continue;

            visited[to] = true;
            cost += time;

            for (int next = 0; next < n; next++) {
                int weight = Math.abs(points[to][0] - points[next][0]) + Math.abs(points[to][1] - points[next][1]);
                if (!visited[next] && min[next] <= weight)
                    continue;

                min[next] = weight;
                minHeap.offer(new int[] {next, min[next]});
            }
        }
        return cost;
    }
}
