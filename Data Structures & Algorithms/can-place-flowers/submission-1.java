class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int k) {
        if(k==0) return true;
        int n = flowerbed.length;
        for (int i = 0; i < n; i++) {
            int prev = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == n - 1 ? 0 : flowerbed[i + 1];
            if (prev == 0 && flowerbed[i] == 0 && next == 0) {
                --k;
                flowerbed[i] = 1;
                if (k == 0)
                    return true;
            }
        }
        return false;
    }
}