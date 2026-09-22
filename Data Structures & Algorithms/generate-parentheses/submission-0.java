class Solution {
    private List<String> list;
    private void backtrack(StringBuilder sb, int open, int close, int max){
        if(close==max){
            list.add(sb.toString());
            return;
        }

        if(open<max){
            int l=sb.length();
            sb.append('(');
            backtrack(sb, open+1, close, max);
            sb.setLength(l);
        }
        if(close<open){
            int l=sb.length();
            sb.append(')');
            backtrack(sb, open, close+1, max);
            sb.setLength(l);
        }
    }
    public List<String> generateParenthesis(int n) {
        this.list=new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return this.list;
    }
}
