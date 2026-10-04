class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        int maxLen = 0;
        for (String str : set) maxLen = Math.max(maxLen, str.length());

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && i - j <= maxLen; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
