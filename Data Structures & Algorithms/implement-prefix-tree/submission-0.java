class PrefixTree {
    private class TrieNode {
        boolean isEnd = false;
        TrieNode[] next = new TrieNode[26];
    }

    private TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null)
                return false;
            node = node.next[i];
        }
        return node.isEnd;
    }

    public boolean startsWith(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.next[i] == null)
                return false;
            node = node.next[i];
        }
        return true;
    }
}
