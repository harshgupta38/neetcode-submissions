class Solution {
    public int countSubstrings(String s) {
        char[] ch=s.toCharArray();
        int n=ch.length;
        int count=0;
        for(int i=0;i<n;i++){
            int l=i,r=i;
            while(l>=0 && r<n && ch[l]==ch[r]){
                ++count;
                --l;
                ++r;
            }

            l=i;
            r=i+1;
            while(l>=0 && r<n && ch[l]==ch[r]){
                ++count;
                --l;
                ++r;
            }
        }
        return count;
    }
}
