class Solution {
    private int rows, cols;
    private char[][] board;

    private void safe(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O')
            return;
        board[i][j] = 'S';

        safe(i - 1, j);
        safe(i, j + 1);
        safe(i + 1, j);
        safe(i, j - 1);
    }

    public void solve(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                safe(i, 0);
            if (board[i][cols - 1] == 'O')
                safe(i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O')
                safe(0, j);
            if (board[rows - 1][j] == 'O')
                safe(rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'S')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
