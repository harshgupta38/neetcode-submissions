class Solution {
    private char[][] grid;
    private int rows, cols;

    private void drown(int i, int j){
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]=='0') return;

        grid[i][j]='0';
        drown(i-1, j);
        drown(i, j+1);
        drown(i+1, j);
        drown(i, j-1);
    }

    public int numIslands(char[][] grid) {
        this.grid=grid;
        this.rows=grid.length;
        this.cols=grid[0].length;

        int count=0;
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(grid[i][j]=='1'){
            ++count;
            drown(i,j);
        }
        return count;
    }
}
