class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, left = 0;
        int n = s.length();
        int ans = 0;

        for (int right = 0; right < n; right++) {
            char rch = s.charAt(right);
            ++freq[rch - 'A'];
            maxFreq = Math.max(maxFreq, freq[rch - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                char lch = s.charAt(left);
                --freq[lch - 'A'];
                ++left;
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
