class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) time[i] = Integer.MAX_VALUE;
        time[k] = 0;

        Map<Integer, List<int[]>> map = new HashMap<>(); //[node, time]
        for (int[] data : times) {
            int from = data[0], to = data[1], t = data[2];
            map.computeIfAbsent(from, o -> new ArrayList<>()).add(new int[] {to, t});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]); //[node, time]
        queue.offer(new int[] {k, 0});

        boolean[] visited = new boolean[n + 1];
        visited[k] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int timeToReachHere = now[1];
            if (map.containsKey(now[0])) {
                for (int[] next : map.get(now[0])) {
                    int to = next[0], weight = next[1];
                    if (visited[to])
                        continue;

                    if (time[to] > timeToReachHere + weight) {
                        time[to] = timeToReachHere + weight;
                        queue.offer(new int[] {to, time[to]});
                    }
                }
            }
        }

        int max = 0;
        for (int num : time) max = Math.max(max, num);
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
