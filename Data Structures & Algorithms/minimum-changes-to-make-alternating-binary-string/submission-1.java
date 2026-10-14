class Solution {
    public int minOperations(String s) {
        boolean isZero = s.charAt(0) == '0';
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isZero && ch != '0')
                ++c;
            else if (!isZero && ch == '0')
                ++c;

            isZero = !isZero;
        }
        return Math.min(c, s.length()-c);
    }
}