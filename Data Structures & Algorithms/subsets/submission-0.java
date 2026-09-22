class Solution {
    List<List<Integer>> list;

    public List<List<Integer>> subsets(int[] nums) {
        this.list = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0);
        return this.list;
    }

    private void backtrack(List<Integer> list, int[] nums, int i) {
        this.list.add(new ArrayList<>(list));
        if (i == nums.length)
            return;

        for (; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(list, nums, i + 1);
            list.removeLast();
        }
    }
}
