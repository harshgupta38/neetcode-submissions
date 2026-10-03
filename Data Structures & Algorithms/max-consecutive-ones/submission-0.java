class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0, a = 0;
        for (int n : nums) {
            if (n == 1) {
                ++c;
                a = Math.max(a, c);
            } else
                c = 0;
        }
        return a;
    }
}