class Solution {
    public int appendCharacters(String t, String s) {
        int i = 0, sn = s.length();
        int j = 0, tn = t.length();
        while (i < sn) {
            if (j == tn)
                break;

            if (s.charAt(i) == t.charAt(j))
                ++i;
            ++j;
        }
        return sn - i;
    }
}

// coding -> coaching