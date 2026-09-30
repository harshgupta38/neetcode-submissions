class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (index.containsKey(nums[i])) {
                int diff = Math.abs(i - index.get(nums[i]));
                if (diff <= k)
                    return true;
            }
            index.put(nums[i], i);
        }
        return false;
    }
}