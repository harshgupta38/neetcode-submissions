class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        char[] ch = s.toCharArray();
        int n = ch.length;

        int prev = 0;
        int zero = 1;

        for (int i = 0; i < n; i++) {
            int next = 0;
            if (ch[i] != '0')
                next = zero;

            if (i > 0 && ch[i - 1] != '0') {
                int num = ((ch[i - 1] - '0') * 10) + (ch[i] - '0');
                if (num >= 10 && num <= 26)
                    next += prev;
            }
            prev = zero;
            zero = next;
        }
        return zero;
    }
}
