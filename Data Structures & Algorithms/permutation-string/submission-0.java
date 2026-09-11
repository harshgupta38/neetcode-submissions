class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] need=new int[26];
        
        for(char ch:s1.toCharArray())
            ++need[ch-'a'];

        int[] have=new int[26];
        for(int i=0;i<s2.length();i++){
            char rch=s2.charAt(i);
            ++have[rch-'a'];
            if(i>=s1.length())
            --have[s2.charAt(i-s1.length())-'a'];

            if(Arrays.equals(need, have)) return true;
        }

        return false;
    }
}
