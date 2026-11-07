class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) sb.append(str.length()).append('#').append(str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int n = str.length();
        int len = 0;
        for (int i = 0; i < n;) {
            char ch = str.charAt(i);
            if (ch == '#') {
                String word = str.substring(i + 1, i + 1 + len);
                list.add(word);
                i += len + 1;
                len = 0;
            } else if (Character.isDigit(ch)) {
                len = len * 10 + (ch - '0');
                ++i;
            } else {
                ++i;
            }
        }
        return list;
    }
}
