class Solution {
    public int mySqrt(int x) {
        // Base case for 0 and 1
        if (x < 2) return x;

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Cast to long to prevent overflow during multiplication
            long pow = (long) mid * mid;

            if (pow == x) {
                return mid;
            } else if (pow < x) {
                ans = mid; // Potential answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Return 'right' or 'ans', dono hi floor value denge
        return right;
    }
}