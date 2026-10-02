class Solution {
    public String foreignDictionary(String[] words) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[26];

        // Keep track of which letters actually appear in the words
        boolean[] present = new boolean[26];
        int uniqueCharacters = 0;
        for (String word : words) 
            for (char c : word.toCharArray()) 
            if(!present[c - 'a']){
                present[c - 'a'] = true;
                ++uniqueCharacters;
            }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];
            int l = Math.min(first.length(), second.length());

            boolean foundDifference = false;
            for (int j = 0; j < l; j++) {
                int a = first.charAt(j) - 'a';
                int b = second.charAt(j) - 'a';

                if (a != b) {
                    if (map.computeIfAbsent(a, k -> new HashSet<>()).add(b)) 
                        indegree[b]++;

                    foundDifference = true;
                    break;
                }
            }
            if (!foundDifference && first.length() > second.length())
                return "";
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add every character with indegree 0.
        // We must also include characters that have NO edges.
        for (int i = 0; i < 26; i++) 
            if (present[i] && indegree[i] == 0) 
                queue.offer(i);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append((char) (now + 'a'));

            if (map.containsKey(now)) {
                for (int next : map.get(now)) {
                    indegree[next]--;

                    if (indegree[next] == 0) 
                        queue.offer(next);
                }
            }
        }

        if (sb.length() != uniqueCharacters) 
            return "";

        return sb.toString();
    }
}