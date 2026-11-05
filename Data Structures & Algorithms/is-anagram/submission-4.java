class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length() && hash(s).equals(hash(t)))
            return true;
        return false;
    }

    private String hash(String str) {
        char[] ch = new char[26];
        for (char c : str.toCharArray()) ++ch[c - 'a'];
        return new String(ch);
    }
}
