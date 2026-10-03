class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (ch[i - 1] != '0')
                dp[i] += dp[i - 1];
            if (i > 1 && ch[i - 2] != '0') {
                int num = ((ch[i - 2] - '0') * 10) + (ch[i - 1] - '0');
                // int num = Integer.parseInt(s.substring(i - 2, i));
                if (num >= 10 && num <= 26)
                    dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
