class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int steps = 1, n = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++steps;
            
            for (int z = 0; z < size; z++) {
                char[] word = queue.poll().toCharArray();

                for (int i = 0; i < n; i++) {
                    char original = word[i];

                    for (char newCh = 'a'; newCh <= 'z'; newCh++) {
                        if (newCh == original)
                            continue;

                        word[i] = newCh;
                        String newWord = new String(word);
                        if (newWord.equals(endWord))
                            return steps;

                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    word[i] = original;
                }
            }
        }
        return 0;
    }
}
