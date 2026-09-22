class Solution {
    private List<List<String>> list;
    private char[] ch;
    private String s;

    private void backtrack(List<String> list, int start) {
        if (start == ch.length) {
            this.list.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < ch.length; i++) {
            if (isPalin(start, i)) {
                list.add(s.substring(start, i + 1));
                backtrack(list, i + 1);
                list.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        this.list = new ArrayList<>();
        this.ch = s.toCharArray();
        this.s = s;
        backtrack(new ArrayList<>(), 0);
        return this.list;
    }

    private boolean isPalin(int left, int right) {
        while (left < right)
            if (ch[left++] != ch[right--])
                return false;
        return true;
    }
}
