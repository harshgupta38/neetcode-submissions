class Solution {
    public String foreignDictionary(String[] words) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[26];

        // Keep track of which letters actually appear in the words
        boolean[] present = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int l = Math.min(first.length(), second.length());

            boolean foundDifference = false;

            for (int j = 0; j < l; j++) {

                int a = first.charAt(j) - 'a';
                int b = second.charAt(j) - 'a';

                if (a != b) {

                    // We found the first different character.
                    // Therefore: a -> b
                    //
                    // IMPORTANT:
                    // Don't add the same edge multiple times.
                    if (!map.containsKey(a) || !map.get(a).contains(b)) {
                        map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                        indegree[b]++;
                    }

                    foundDifference = true;
                    break;
                }
            }

            // INVALID PREFIX CASE
            //
            // Example: ["abc", "ab"]
            // "ab" cannot come after "abc".
            if (!foundDifference && first.length() > second.length()) {
                return "";
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add every character with indegree 0.
        // We must also include characters that have NO edges.
        for (int i = 0; i < 26; i++) {
            if (present[i] && indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {

            int now = queue.poll();
            sb.append((char) (now + 'a'));

            if (map.containsKey(now)) {

                for (int next : map.get(now)) {

                    indegree[next]--;

                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        // If we couldn't process every character,
        // there is a cycle -> invalid dictionary.
        int uniqueCharacters = 0;

        for (boolean exists : present) {
            if (exists) {
                uniqueCharacters++;
            }
        }

        if (sb.length() != uniqueCharacters) {
            return "";
        }

        return sb.toString();
    }
}