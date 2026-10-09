class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s : strs) {
            String hash = hash(s);
            int i = map.getOrDefault(hash, -1);
            if (i == -1) {
                map.put(hash, list.size());
                List<String> l = new ArrayList<>();
                l.add(s);
                list.add(l);
            } else {
                list.get(i).add(s);
            }
        }

        return list;
    }

    private String hash(String s) {
        char[] freq = new char[26];
        for (char ch : s.toCharArray()) ++freq[ch - 'a'];
        return new String(freq);
    }
}
