class Solution {
    private boolean[][] rows, cols, box;
    private char[][] board;

    private boolean backtrack(int i, int j) {
        if (i == 9)
            return true;
        if (j == 9)
            return backtrack(i + 1, 0);
        if (board[i][j] == '.')
            return backtrack(i, j + 1);

        int b = box(i, j);
        int val = board[i][j] - '0' - 1;
        if (rows[i][val] || cols[j][val] || box[b][val])
            return false;

        rows[i][val] = cols[j][val] = box[b][val] = true;
        return backtrack(i, j + 1);
    }

    private int box(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }

    public boolean isValidSudoku(char[][] board) {
        this.rows = new boolean[9][9];
        this.cols = new boolean[9][9];
        this.box = new boolean[9][9];
        this.board = board;
        return backtrack(0, 0);
    }
}
