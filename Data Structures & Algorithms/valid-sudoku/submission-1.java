class Solution {
    private char[][] board;
    private boolean[][] rows, cols, box;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        this.rows = new boolean[9][10];
        this.cols = new boolean[9][10];
        this.box = new boolean[9][10];

        return isValid(0, 0);
    }

    private boolean isValid(int i, int j) {
        if (i == 9)
            return true;
        if (j == 9)
            return isValid(i + 1, 0);
        if (board[i][j] == '.')
            return isValid(i, j + 1);

        int val = board[i][j] - '0';
        if (rows[i][val] || cols[j][val] || box[box(i, j)][val])
            return false;
        rows[i][val] = cols[j][val] = box[box(i, j)][val] = true;
        return isValid(i, j + 1);
    }

    private int box(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }
}
