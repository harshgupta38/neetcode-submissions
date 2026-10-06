class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String str : set) maxLen = Math.max(maxLen, str.length());

        int n = s.length();
        boolean[] seen = new boolean[n + 1];
        seen[0] = true;
        for (int r = 1; r <= n; r++) {
            for (int l = r - 1; l >= 0 && r - l <= maxLen; l--) {
                if (seen[l] && set.contains(s.substring(l, r))) {
                    seen[r] = true;
                    break;
                }
            }
        }
        return seen[n];
    }
}
