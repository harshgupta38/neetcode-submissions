class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int match = 0;
        for (int ch : s.toCharArray()) {
            ++freq[ch - 'a'];
            if (freq[ch - 'a'] == 1)
                ++match;
        }
        for (int ch : t.toCharArray()) {
            --freq[ch - 'a'];
            if (freq[ch - 'a'] == -1)
                return false;
            if (freq[ch - 'a'] == 0)
                --match;
        }
        return match == 0;
    }
}
