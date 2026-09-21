class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int t : tasks) ++freq[t - 'A'];

        int maxFreq = 0, maxFreqCount = 0;
        for (int f : freq) {
            if (maxFreq < f) {
                maxFreq = f;
                maxFreqCount = 1;
            } else if (maxFreq == f)
                ++maxFreqCount;
        }

        int window1 = (maxFreq - 1) * (n + 1) + maxFreqCount;
        return Math.max(tasks.length, window1);
    }
}
