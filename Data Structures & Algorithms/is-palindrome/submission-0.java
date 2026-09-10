class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        char[] ch=s.toLowerCase().toCharArray();
        int l=0, r=n-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(ch[l])) ++l;
            while(l<r && !Character.isLetterOrDigit(ch[r])) --r;

            if(ch[l]!=ch[r]) return false;
            ++l;
            --r;
        }
        return true;
    }
}
