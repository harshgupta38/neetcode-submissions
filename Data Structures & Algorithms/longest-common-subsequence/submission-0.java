class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int rows = s1.length();
        int cols = s2.length();

        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            char ch1 = s1.charAt(i - 1);
            for (int j = 1; j <= cols; j++) {
                char ch2 = s2.charAt(j - 1);
                if (ch1 == ch2)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[rows][cols];
    }
}

//     c r a b t
//   0 0 0 0 0 0 
// c 0 1 1 1 1 1
// a 0 1 1 2 2 2
// t 0 1 1 2 2 3
