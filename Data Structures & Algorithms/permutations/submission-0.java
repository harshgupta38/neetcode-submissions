class Solution {
    private List<List<Integer>> list;
    private int[] nums;
    private boolean[] used;

    private void backtrack(List<Integer> list) {
        if (list.size() == nums.length) {
            this.list.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            list.add(nums[i]);
            used[i] = true;
            backtrack(list);
            list.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.list = new ArrayList<>();
        this.nums = nums;
        this.used = new boolean[nums.length];

        backtrack(new ArrayList<>());
        return this.list;
    }
}
