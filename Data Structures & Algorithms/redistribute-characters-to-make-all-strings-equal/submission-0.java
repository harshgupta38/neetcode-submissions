class Solution {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        int totLen = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) ++freq[ch - 'a'];
            totLen += word.length();
        }
        int n = words.length;
        if (totLen % n != 0)
            return false;

        for (int f : freq)
            if (f > 0 && f % n != 0)
                return false;
        return true;
    }
}