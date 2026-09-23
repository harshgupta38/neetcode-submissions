class Solution {
    private class TrieNode {
        String word = null;
        TrieNode[] next = new TrieNode[26];
    }

    private char[][] board;
    private TrieNode root;
    private List<String> list;
    private int rows, cols;

    private void add(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null)
                node.next[i] = new TrieNode();
            node = node.next[i];
        }
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.root = new TrieNode();
        this.list = new ArrayList<>();
        for (String word : words) add(word);
        this.rows = board.length;
        this.cols = board[0].length;

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                int ch = board[i][j] - 'a';
                if (root.next[ch] != null)
                    backtrack(i, j, root);
            }
        return this.list;
    }

    private void backtrack(int i, int j, TrieNode node) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '#')
            return;

        char ch = board[i][j];
        if (node.next[ch - 'a'] == null)
            return;
        node = node.next[ch - 'a'];

        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        backtrack(i - 1, j, node);
        backtrack(i, j + 1, node);
        backtrack(i + 1, j, node);
        backtrack(i, j - 1, node);
        board[i][j] = ch;
    }
}
