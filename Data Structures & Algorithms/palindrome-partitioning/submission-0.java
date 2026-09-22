class Solution {
    private List<List<String>> list;
    private char[] ch;
    private String s;

    private void backtrack(int left, int right, List<String> list) {
        if (left > right) {
            this.list.add(new ArrayList<>(list));
            return;
        }

        for (int i = left; i <= right; i++) {
            if (isPalin(left, i)) {
                list.add(s.substring(left, i + 1));
                backtrack(i + 1, right, list);
                list.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        this.list = new ArrayList<>();
        this.ch = s.toCharArray();
        this.s = s;
        backtrack(0, ch.length - 1, new ArrayList<>());
        return this.list;
    }

    private boolean isPalin(int left, int right) {
        while (left < right)
            if (ch[left++] != ch[right--])
                return false;
        return true;
    }
}
