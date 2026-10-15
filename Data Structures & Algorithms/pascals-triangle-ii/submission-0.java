class Solution {
    public List<Integer> getRow(int n) {
        n += 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j >= 1; j--) {
                // System.out.print(j + " ");
                dp[j] += dp[j - 1];
            }
            // System.out.println();
        }
        return Arrays.stream(dp).boxed().toList();
    }
}