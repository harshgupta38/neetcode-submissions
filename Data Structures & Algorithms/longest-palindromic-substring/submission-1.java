class Solution {
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int start = 0, max = 0, n = ch.length;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && ch[l] == ch[r]) {
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    start = l;
                }
                --l;
                ++r;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && ch[l] == ch[r]) {
                if (r - l + 1 > max) {
                    max = r - l + 1;
                    start = l;
                }
                --l;
                ++r;
            }
        }
        return s.substring(start, start + max);
    }
}
