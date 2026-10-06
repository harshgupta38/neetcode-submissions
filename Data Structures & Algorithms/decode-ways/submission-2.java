class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ch[i] != '0')
                dp[i] = dp[i - 1];

            int val = ((ch[i - 1] - '0') * 10) + (ch[i] - '0');
            if (val >= 10 && val <= 26)
                dp[i] += i == 1 ? 1 : dp[i - 2];
        }
        return dp[n - 1];
    }
}
