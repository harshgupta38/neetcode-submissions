class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0, n = s.length();
        int left = 0, ans=0;
        for (int right = 0; right < n; right++) {
            int ch=s.charAt(right)-'A';
            ++freq[ch];
            maxFreq=Math.max(maxFreq, freq[ch]);

            while((right-left+1)-maxFreq > k){
                int lch=s.charAt(left)-'A';
                --freq[lch];
                ++left;
            }
            ans=Math.max(ans, right-left+1);
        }
        return ans;
    }
}
