class Solution {
    public boolean isPalindrome(String s) {
        char[] ch=s.toLowerCase().toCharArray();
        int n=ch.length;
        int l=0, r=n-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(ch[l])) ++l;
            while(l<r && !Character.isLetterOrDigit(ch[r])) --r;

            if(l>=r) break;

            if(ch[l]!=ch[r]) return false;

            ++l;
            --r;
        }
        return true;
    }
}
