class Solution {
    public String minWindow(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if (tn > sn)
            return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) need.put(ch, need.getOrDefault(ch, 0) + 1);

        int left = 0, start = 0, min = sn + 1, match = tn;
        for (int right = 0; right < sn; right++) {
            char rch = s.charAt(right);
            if (need.containsKey(rch)) {
                if (need.get(rch) > 0)
                    --match;
                need.put(rch, need.get(rch) - 1);
            }

            while (match == 0) {
                if (right - left + 1 < min) {
                    start = left;
                    min = right - left + 1;
                }

                char lch = s.charAt(left);
                if (need.containsKey(lch)) {
                    need.put(lch, need.get(lch) + 1);
                    if (need.get(lch) > 0)
                        ++match;
                }
                ++left;
            }
        }
        return min == sn + 1 ? "" : s.substring(start, start + min);
    }
}
