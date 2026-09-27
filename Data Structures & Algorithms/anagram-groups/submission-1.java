class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hash = hash(str);
            map.computeIfAbsent(hash, o -> new ArrayList<>()).add(str);
        }
        List<List<String>> list = new ArrayList<>();
        for (String key : map.keySet()) list.add(map.get(key));
        return list;
    }

    private String hash(String str) {
        char[] freq = new char[26];
        for (char ch : str.toCharArray()) ++freq[ch - 'a'];
        return new String(freq);
    }
}
