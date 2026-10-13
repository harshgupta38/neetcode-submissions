class Solution {
    public int maxScore(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length, max = 0;
        for (int i = 1; i < n; i++) {
            int l = count(ch, 0, i - 1, '0');
            int r = count(ch, i, n - 1, '1');
            max = Math.max(max, l + r);
        }
        return max;
    }

    private int count(char[] ch, int l, int r, char m) {
        int c = 0;
        for (int i = l; i <= r; i++)
            if (ch[i] == m)
                ++c;
        return c;
    }
}