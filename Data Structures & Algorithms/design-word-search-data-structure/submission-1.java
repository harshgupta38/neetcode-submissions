class WordDictionary {
    private class TrieNode {
        boolean isEnd = false;
        TrieNode[] next = new TrieNode[26];
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null)
                node.next[i] = new TrieNode();
            node = node.next[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNode node) {
        if (i == word.length())
            return node.isEnd;

        char ch = word.charAt(i);
        if (ch == '.') {
            for (int idx = 0; idx < 26; idx++) {
                if (node.next[idx] != null && search(word, i + 1, node.next[idx]))
                    return true;
            }
            return false;
        } else {
            int idx = ch - 'a';
            if (node.next[idx] == null)
                return false;
            return search(word, i + 1, node.next[idx]);
        }
    }
}
