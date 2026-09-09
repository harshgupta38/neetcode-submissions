class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            sb.append(len).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // System.out.println(str);
        List<String> list = new ArrayList<>();
        int n = str.length();
        int i = 0;
        while (i < n) {
            int len = 0;
            while (i<n && str.charAt(i) != '#' && Character.isDigit(str.charAt(i))) {
                len = len * 10 + (str.charAt(i) - '0');
                ++i;
            }
            // System.out.println(i+" "+len);
            String sub = str.substring(i + 1, i + len+1);
            list.add(sub);
            i+=len+1;
        }
        return list;
    }
}
