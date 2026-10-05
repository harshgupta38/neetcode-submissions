class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            ++freq[ch - 'a'];

        int maxodd = 0;
        int mineven = s.length() + 1;

        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 1)
                    maxodd = Math.max(maxodd, f);
                else
                    mineven = Math.min(mineven, f);
            }
        }

        return maxodd - mineven;
    }
}