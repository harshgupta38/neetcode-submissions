class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, sn = s.length();
        int j = 0, tn = t.length();
        while (i < sn) {
            if (j == tn)
                return false;

            if (s.charAt(i) == t.charAt(j)) 
                ++i;
            ++j;
        }
        return true;
    }
}