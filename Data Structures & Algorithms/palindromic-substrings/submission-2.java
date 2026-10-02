class Solution {
    public int countSubstrings(String s) {
        char[] ch = s.toCharArray();
        int count = 0, n = ch.length;
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (ch[l] != ch[r])
                    break;
                ++count;
                --l;
                ++r;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n) {
                if (ch[l] != ch[r])
                    break;
                ++count;
                --l;
                ++r;
            }
        }
        return count;
    }
}
