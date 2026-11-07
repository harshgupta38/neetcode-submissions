class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int l = 0, r = ch.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(ch[l])) ++l;
            while (l < r && !Character.isLetterOrDigit(ch[r])) --r;

            if (ch[l] != ch[r])
                return false;

            ++l;
            --r;
        }
        return true;
    }
}
