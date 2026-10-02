class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], time = flight[2];
            map.computeIfAbsent(from, o -> new ArrayList<>()).add(new int[] {to, time});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0});
        while (!queue.isEmpty() && k >= 0) {
            --k;
            int size = queue.size();
            for (int z = 0; z < size; z++) {
                int[] now = queue.poll();
                int from = now[0];
                int timeToReachHere = now[1];
                if (map.containsKey(from)) {
                    for (int[] next : map.get(from)) {
                        int to = next[0], time = next[1];
                        if (dist[to] > timeToReachHere + time) {
                            dist[to] = timeToReachHere + time;
                            queue.offer(new int[] {to, dist[to]});
                        }
                    }
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
