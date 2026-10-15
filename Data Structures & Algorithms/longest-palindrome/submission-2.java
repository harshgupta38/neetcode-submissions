class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];

        for (char ch : s.toCharArray())
            freq[ch]++;

        int len = 0;

        for (int f : freq) 
            len += (f / 2) * 2;

        if (len < s.length())
            len++;

        return len;
    }
}