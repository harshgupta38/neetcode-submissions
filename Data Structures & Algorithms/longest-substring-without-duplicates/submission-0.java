class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last=new int[256];
        Arrays.fill(last, -1);
        int left=0, max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            left=Math.max(left, last[ch]+1);
            max=Math.max(max, i-left+1);
            last[ch]=i;
        }
        return max;
    }
}
