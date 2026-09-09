class Solution {
    public boolean isAnagram(String s, String t) {
        int sn=s.length();
        int tn=t.length();

        if(sn!=tn) return false;

        int[] freq=new int[26];
        int match=0;
        for(int i=0;i<sn;i++){
            int chs=s.charAt(i)-'a';
            int cht=t.charAt(i)-'a';

            ++freq[chs];
            if(freq[chs]==1)
                ++match;
            else if(freq[chs]==0)
                --match;

            --freq[cht];
            if(freq[cht]==0)
                --match;
            else if(freq[cht]==-1)
                ++match;
        }
        return match==0;
    }
}
