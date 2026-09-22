class Solution {
    private List<List<Integer>> list;
    private int[] nums;

    private void backtrack(List<Integer> list, int start) {
        this.list.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i])
                continue;
            
            list.add(nums[i]);
            backtrack(list, i+1);
            list.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.list=new ArrayList<>();
        Arrays.sort(nums);
        this.nums=nums;
        backtrack(new ArrayList<>(), 0);
        return this.list;
    }
}
