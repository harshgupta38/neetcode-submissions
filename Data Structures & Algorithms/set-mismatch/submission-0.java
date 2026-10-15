class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = n;
        for (int i = 0; i < n; i++) xor = xor ^ i ^ nums[i];

        int setBit = xor & -xor;

        int a = 0, b = 0;

        // Step 3: Partition array elements
        for (int num : nums) {
            if ((num & setBit) == 0)
                a ^= num;
            else
                b ^= num;
        }

        // Partition expected numbers too
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) == 0)
                a ^= i;
            else
                b ^= i;
        }

        // Step 4: Identify duplicate and missing
        for (int num : nums) {
            if (num == a)
                return new int[] {a, b};
        }

        return new int[] {b, a};
    }
}