class Solution {
    public String largestGoodInteger(String num) {
        int val = -1;
        String ans = "";
        char[] ch = num.toCharArray();
        for (int i = 2; i < ch.length; i++) {
            if (ch[i - 2] == ch[i - 1] && ch[i - 1] == ch[i]) {
                int v = ch[i] - '0';
                if (val < v) {
                    val = v;
                    ans = num.substring(i - 2, i + 1);
                }
            }
        }
        return ans;
    }
}