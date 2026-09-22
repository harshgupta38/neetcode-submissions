class Solution {
    private List<List<Integer>> list;
    private int[] nums;
    private int target;

    private void backtrack(List<Integer> list, int start, int sum) {
        if (sum == target) {
            this.list.add(new ArrayList<>(list));
            return;
        }
        if (sum > target)
            return;

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target)
                return;
            if (i > start && nums[i - 1] == nums[i])
                continue;
            list.add(nums[i]);
            backtrack(list, i + 1, sum + nums[i]);
            list.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        this.list = new ArrayList<>();
        this.nums = nums;
        this.target = target;

        backtrack(new ArrayList<>(), 0, 0);
        return this.list;
    }
}
