class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        Set<String> list = new HashSet<>();
        for (String word : words) {
            if (sb.toString().contains(word))
                list.add(word);
            sb.append(word).append('_');
        }
        sb.setLength(0);
        for (int i = n - 1; i >= 0; i--) {
            if (sb.toString().contains(words[i]))
                list.add(words[i]);
            sb.append(words[i]).append('_');
        }
        return new ArrayList<>(list);
    }
}