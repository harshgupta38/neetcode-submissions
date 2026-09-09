class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        for(String str:strs){
            String hash=hash(str);
            if(map.containsKey(hash))
                list.get(map.get(hash)).add(str);
            else{
                List<String> l=new ArrayList<>();
                l.add(str);
                map.put(hash, list.size());
                list.add(l);
            }
        }
        return list;
    }

    private String hash(String str){
        char[] ch=new char[26];
        for(char c:str.toCharArray())
        ++ch[c-'a'];
        return new String(ch);
    }
}
