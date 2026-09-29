class Solution {
    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        return isPalin(ch, 0, ch.length - 1, false);
    }

    private boolean isPalin(char[] ch, int left, int right, boolean deleted) {
        if (left == right)
            return true;

        while (left < right) {
            if (ch[left] != ch[right])
                if (deleted)
                    return false;
                else
                    return isPalin(ch, left + 1, right, true) || isPalin(ch, left, right - 1, true);

            ++left;
            --right;
        }
        return true;
    }
}