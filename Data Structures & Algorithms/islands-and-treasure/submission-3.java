class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 0)
                    queue.offer(new int[] {i, j});

        int level = 0;
        int MAX = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] data = queue.poll();
                int r = data[0], c = data[1];
                if(grid[r][c]<=level && level>0) continue;
                grid[r][c] = level;

                if (r - 1 >= 0 && grid[r - 1][c] != -1)
                    queue.offer(new int[] {r - 1, c});
                if (c + 1 < cols && grid[r][c + 1] != -1)
                    queue.offer(new int[] {r, c + 1});
                if (r + 1 < rows && grid[r + 1][c] != -1)
                    queue.offer(new int[] {r + 1, c});
                if (c - 1 >= 0 && grid[r][c - 1] != -1)
                    queue.offer(new int[] {r, c - 1});
            }
            ++level;
        }
    }
}
