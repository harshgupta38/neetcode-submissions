class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] seen = new boolean[26];
        for (char ch : allowed.toCharArray()) seen[ch - 'a'] = true;

        int ans = 0;
        for (String word : words) {
            boolean valid = true;
            for (char ch : word.toCharArray())
                if (!seen[ch - 'a']) {
                    valid = false;
                    break;
                }
            if (valid)
                ++ans;
        }
        return ans;
    }
}