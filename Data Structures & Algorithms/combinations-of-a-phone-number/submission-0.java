class Solution {
    private String[] btn = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> list;
    private String digits;
    private int n;

    private void backtrack(StringBuilder sb, int i) {
        if (i == n) {
            list.add(sb.toString());
            return;
        }

        int n = sb.length();
        int c = digits.charAt(i) - '0';
        for (char ch : btn[c].toCharArray()) {
            sb.append(ch);
            backtrack(sb, i + 1);
            sb.setLength(n);
        }
    }

    public List<String> letterCombinations(String digits) {
        this.list = new ArrayList<>();
        this.digits = digits;
        this.n = digits.length();

        if (n == 0)
            return this.list;

        backtrack(new StringBuilder(), 0);
        return this.list;
    }
}
