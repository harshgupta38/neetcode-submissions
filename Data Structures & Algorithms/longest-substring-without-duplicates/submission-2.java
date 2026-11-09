class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0;
        int[] index = new int[256];
        Arrays.fill(index, -1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            left = Math.max(left, index[ch] + 1);
            max = Math.max(max, i - left + 1);
            index[ch] = i;
        }
        return max;
    }
}
