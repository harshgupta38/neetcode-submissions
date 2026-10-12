class Solution {
    public int maxNumberOfBalloons(String text) {
        int [] freq=new int[26];
        for(char ch:text.toCharArray()) 
            if(ch=='b' || ch=='a' || ch=='l' || ch=='o' || ch=='n')
                ++freq[ch-'a'];
        
        freq['l'-'a']/=2;
        freq['o'-'a']/=2;

        int min=freq['b'-'a']; // b
        min=Math.min(min, freq[0]); // a
        min=Math.min(min, freq['l'-'a']); // l
        min=Math.min(min, freq['o'-'a']); // o
        return Math.min(min, freq['n'-'a']); // n
    }
}