class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 1)
                    ++fresh;
                else if (grid[i][j] == 2)
                    queue.offer(new int[] {i, j});

        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int z = 0; z < size; z++) {
                int[] data = queue.poll();
                int i = data[0], j = data[1];

                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    --fresh;
                    queue.offer(new int[] {i - 1, j});
                }
                if (j + 1 < cols && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    --fresh;
                    queue.offer(new int[] {i, j + 1});
                }
                if (i + 1 < rows && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    --fresh;
                    queue.offer(new int[] {i + 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    --fresh;
                    queue.offer(new int[] {i, j - 1});
                }
            }
            ++time;
        }
        return fresh > 0 ? -1 : time;
    }
}
