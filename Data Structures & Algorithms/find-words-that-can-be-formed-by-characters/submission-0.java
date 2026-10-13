class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] have=new int[26];
        for(char ch:chars.toCharArray()) ++have[ch-'a'];

        int ans=0;
        for(String word:words){
            int[] need=new int[26];
            boolean valid=true;
            for(char ch:word.toCharArray()){
                ++need[ch-'a'];
                if(need[ch-'a']>have[ch-'a']){
                    valid=false;
                    break;
                }
            }
            if(valid)
                ans+=word.length();
        }
        return ans;
    }
}