class Solution {
    private char[][] board;
    private int rows, cols;
    private char[] ch;

    private boolean search(int i, int j, int idx){
        if(idx==ch.length) return true;
        if(i<0 || i>=rows || j<0 || j>=cols || board[i][j]=='#') return false;
        if(ch[idx]!=board[i][j]) return false;

        board[i][j]='#';
        if(search(i-1, j, idx+1)) return true;
        if(search(i, j+1, idx+1)) return true;
        if(search(i+1, j, idx+1)) return true;
        if(search(i, j-1, idx+1)) return true;
        board[i][j]=ch[idx];
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.rows=board.length;
        this.cols=board[0].length;
        this.ch=word.toCharArray();
        for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
        if(ch[0]==board[i][j] && search(i, j, 0))
        return true;
        return false;
    }
}
