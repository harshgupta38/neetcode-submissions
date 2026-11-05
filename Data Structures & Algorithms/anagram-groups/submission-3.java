class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String str : strs) {
            String hash = hash(str);
            if (map.containsKey(hash))
                list.get(map.get(hash)).add(str);
            else {
                map.put(hash, list.size());
                List<String> l = new ArrayList<>();
                l.add(str);
                list.add(l);
            }
        }
        return list;
    }

    private String hash(String str) {
        char[] freq = new char[26];
        for (char ch : str.toCharArray()) ++freq[ch - 'a'];
        return new String(freq);
    }
}
