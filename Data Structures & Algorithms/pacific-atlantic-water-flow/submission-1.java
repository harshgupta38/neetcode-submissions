class Solution {
    private int rows, cols;
    private int[][] height;
    private boolean[][] pacific, atlantic;

    private void markPacific(int i, int j, int prev) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || height[i][j] < prev
            || pacific[i][j] == true)
            return;

        pacific[i][j] = true;
        markPacific(i - 1, j, height[i][j]);
        markPacific(i, j + 1, height[i][j]);
        markPacific(i + 1, j, height[i][j]);
        markPacific(i, j - 1, height[i][j]);
    }

    private void markAtlantic(int i, int j, int prev) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || height[i][j] < prev
            || atlantic[i][j] == true)
            return;

        atlantic[i][j] = true;
        markAtlantic(i - 1, j, height[i][j]);
        markAtlantic(i, j + 1, height[i][j]);
        markAtlantic(i + 1, j, height[i][j]);
        markAtlantic(i, j - 1, height[i][j]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        this.height = heights;
        this.pacific = new boolean[rows][cols];
        this.atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            markPacific(i, 0, 0);
            markAtlantic(i, cols - 1, 0);
        }

        for (int j = 0; j < cols; j++) {
            markPacific(0, j, 0);
            markAtlantic(rows - 1, j, 0);
        }

        // for(boolean[] row:pacific)
        //     System.out.println(Arrays.toString(row));
        // System.out.println();
        // for(boolean[] row:atlantic)
        //     System.out.println(Arrays.toString(row));

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (pacific[i][j] && atlantic[i][j])
                    list.add(Arrays.asList(i, j));
        return list;
    }
}
