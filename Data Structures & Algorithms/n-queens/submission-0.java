class Solution {
    private char[][] board;
    private List<List<String>> list;
    private boolean[] cols, leftD, rightD;
    private int n;

    private void backtrack(int row) {
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (char[] r : board) l.add(new String(r));
            list.add(l);
        }

        for (int col = 0; col < n; col++) {
            int left = row + col;
            int right = col - row + n;
            if (cols[col] || leftD[left] || rightD[right])
                continue;

            board[row][col] = 'Q';
            cols[col] = leftD[left] = rightD[right] = true;
            backtrack(row + 1);
            board[row][col] = '.';
            cols[col] = leftD[left] = rightD[right] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');
        this.list = new ArrayList<>();
        this.cols = new boolean[n];
        this.leftD = new boolean[n * 2];
        this.rightD = new boolean[n * 2];

        backtrack(0);
        return this.list;
    }
}
