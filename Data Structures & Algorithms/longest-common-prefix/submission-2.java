class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l = strs.length;
        String word = strs[0];
        if (l == 1)
            return word;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char t = word.charAt(i);
            for (int j = 1; j < l; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != t)
                    return word.substring(0, i);
            }
        }
        return word;
    }
}