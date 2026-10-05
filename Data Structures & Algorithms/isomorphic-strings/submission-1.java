class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map1 = new char[256];
        char[] map2 = new char[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (map1[ch1] != '\0' && map1[ch1] != ch2)
                return false;
            if (map2[ch2] != '\0' && map2[ch2] != ch1)
                return false;
            map1[ch1] = ch2;
            map2[ch2] = ch1;
        }
        return true;
    }
}