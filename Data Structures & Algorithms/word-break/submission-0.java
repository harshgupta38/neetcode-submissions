class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i]) {
                for (int j = i + 1; j <= n; j++) {
                    String sub = s.substring(i, j);
                    if (set.contains(sub)) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[n];
    }
}
