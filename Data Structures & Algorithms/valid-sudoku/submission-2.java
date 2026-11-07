class Solution {
    private char[][] board;
    private boolean[][] rows, cols, box;

    private boolean isValid(int i, int j) {
        if (i == 9)
            return true;
        if (j == 9)
            return isValid(i + 1, 0);
        if (board[i][j] == '.')
            return isValid(i, j + 1);

        int x = board[i][j] - '0';
        int b = box(i, j);
        if (rows[i][x] || cols[j][x] || box[b][x])
            return false;

        rows[i][x] = cols[j][x] = box[b][x] = true;

        return isValid(i, j + 1);
    }

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        this.rows = new boolean[10][10];
        this.cols = new boolean[10][10];
        this.box = new boolean[10][10];

        return isValid(0,0);
    }

    private int box(int i, int j) {
        return (i / 3) * 3 + j/3;
    }
}
