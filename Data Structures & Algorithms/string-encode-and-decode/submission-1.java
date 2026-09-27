class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) sb.append(str.length()).append('#').append(str);
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int n = str.length(), i = 0, len = 0;
        while (i < n) {
            char ch = str.charAt(i);
            if (ch != '#') {
                len = len * 10 + (ch - '0');
                ++i;
            } else if (ch == '#') {
                String sub = str.substring(i + 1, i + len + 1);
                list.add(sub);
                i += len + 1;
                len = 0;
            } else {
                ++i;
            }
        }
        return list;
    }
}
