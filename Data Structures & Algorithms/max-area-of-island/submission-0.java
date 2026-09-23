class Solution {
    private int[][] grid;
    private int rows, cols;

    private int drown(int i, int j){
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0) return 0;

        grid[i][j]=0;
        return drown(i - 1, j) +
               drown(i, j + 1) +
               drown(i + 1, j) +
               drown(i, j - 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid=grid;
        this.rows=grid.length;
        this.cols=grid[0].length;
        int max=0;
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(grid[i][j]==1)
        max=Math.max(max, drown(i,j));
        return max;
    }
}
