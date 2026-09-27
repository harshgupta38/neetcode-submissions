class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); // row, col, pathMax
        pq.offer(new int[] {0, 0, grid[0][0]});

        dist[0][0] = grid[0][0];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], pathMax = curr[2];

            // Ignore outdated entry
            if (pathMax > dist[r][c])
                continue;

            // Destination
            if (r == n - 1 && c == n - 1)
                return pathMax;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                int newCost = Math.max(pathMax, grid[nr][nc]);

                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;

                    pq.offer(new int[] {nr, nc, newCost});
                }
            }
        }

        return -1;
    }
}